package g0101_0200.s0200_number_of_islands;

// #Medium #Top_100_Liked_Questions #Top_Interview_Questions #Array #Depth_First_Search
// #Breadth_First_Search #Matrix #Union_Find
// #Algorithm_II_Day_6_Breadth_First_Search_Depth_First_Search
// #Graph_Theory_I_Day_1_Matrix_Related_Problems #Level_1_Day_9_Graph/BFS/DFS #Udemy_Graph
// #Top_Interview_150_Graph_General #Big_O_Time_O(M*N)_Space_O(M*N)
// #2024_11_15_Time_3_ms_(87.24%)_Space_49.6_MB_(39.89%)

public class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        if (grid != null && grid.length != 0 && grid[0].length != 0) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        islands++;
                    }
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || grid.length <= x || y < 0 || grid[0].length <= y || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = 'x';
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
