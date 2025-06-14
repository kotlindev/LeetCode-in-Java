package g3501_3600.s3577_count_the_number_of_computer_unlocking_permutations;

// #Medium #Array #Math #Combinatorics #Brainteaser
// #2025_06_10_Time_1_ms_(100.00%)_Space_62.24_MB_(22.08%)

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPermutations(int[] complexity) {
        int n = complexity.length;
        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }
        long ans = 1;
        for (int x = 2; x < n; x++) {
            ans = (ans * x) % MOD;
        }
        return (int) ans;
    }
}
