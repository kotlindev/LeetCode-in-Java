package g0601_0700.s0647_palindromic_substrings;

// #Medium #Top_100_Liked_Questions #String #Dynamic_Programming

public class Solution {
    private void expand(char[] a, int l, int r, int[] res) {
        while (l >= 0 && r < a.length) {
            if (a[l] != a[r]) {
                return;
            } else {
                res[0]++;
                l--;
                r++;
            }
        }
    }

    public int countSubstrings(String s) {
        char[] a = s.toCharArray();
        int[] res = {0};
        for (int i = 0; i < a.length; i++) {
            expand(a, i, i, res);
            expand(a, i, i + 1, res);
        }
        return res[0];
    }
}