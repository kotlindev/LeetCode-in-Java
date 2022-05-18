package g1901_2000.s1948_delete_duplicate_folders_in_system;

// #Hard #Array #String #Hash_Table #Trie #Hash_Function
// #2022_05_18_Time_92_ms_(97.82%)_Space_69.5_MB_(93.45%)

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<String, ArrayList<Folder>> duplicates;
    private List<List<String>> foldersWithRemovedNames;

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        duplicates = new HashMap<>();
        Folder rootFolder = new Folder("", null);

        for (List<String> path : paths) {
            Folder folder = rootFolder;
            for (String foldername : path) {
                folder = folder.addSubFolder(foldername);
            }
        }

        rootFolder.calculateHash();

        for (Map.Entry<String, ArrayList<Folder>> entry : duplicates.entrySet()) {
            ArrayList<Folder> foldersWithSameHash = entry.getValue();
            if (foldersWithSameHash != null && foldersWithSameHash.size() > 1) {
                for (Folder folder : foldersWithSameHash) {
                    folder.parent.subFolders.remove(folder.name);
                }
            }
        }

        foldersWithRemovedNames = new ArrayList<>();

        for (Map.Entry<String, Folder> entry : rootFolder.subFolders.entrySet()) {
            Folder folder = entry.getValue();
            List<String> path = new ArrayList<>();
            folder.addPaths(path);
        }

        return foldersWithRemovedNames;
    }

    private class Folder {
        public String name;
        public Map<String, Folder> subFolders;
        public Folder parent;
        public String folderHash;

        public Folder(String folderName, Folder parentFolder) {
            name = folderName;
            subFolders = new HashMap<>();
            folderHash = "";
            parent = parentFolder;
        }

        public Folder addSubFolder(String foldername) {
            Folder subFolder = subFolders.get(foldername);
            if (subFolder == null) {
                subFolder = new Folder(foldername, this);
                subFolders.put(foldername, subFolder);
            }

            return subFolder;
        }

        public void calculateHash() {
            List<String> subFolderNames = new ArrayList<>(subFolders.keySet());
            Collections.sort(subFolderNames);
            StringBuilder builder = new StringBuilder();

            for (String foldername : subFolderNames) {
                Folder folder = subFolders.get(foldername);
                folder.calculateHash();
                builder.append('#');
                builder.append(foldername);
                if (folder.folderHash.length() > 0) {
                    builder.append('(');
                    builder.append(folder.folderHash);
                    builder.append(')');
                }
            }

            folderHash = builder.toString();
            if (folderHash.length() > 0) {
                ArrayList<Folder> duplicateFolders =
                        duplicates.computeIfAbsent(folderHash, k -> new ArrayList<>());
                duplicateFolders.add(this);
            }
        }

        public void addPaths(List<String> parentPath) {
            List<String> currentPath = new ArrayList<>(parentPath);
            currentPath.add(name);
            foldersWithRemovedNames.add(currentPath);

            for (Map.Entry<String, Folder> entry : subFolders.entrySet()) {
                Folder folder = entry.getValue();
                folder.addPaths(currentPath);
            }
        }
    }
}