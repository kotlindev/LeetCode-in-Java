package g3401_3500.s3480_maximize_subarrays_after_removing_one_conflicting_pair;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class SolutionTest {
    @Test
    void maxSubarrays() {
        assertThat(new Solution().maxSubarrays(4, new int[][] {{2, 3}, {1, 4}}), equalTo(9L));
    }

    @Test
    void maxSubarrays2() {
        assertThat(
                new Solution().maxSubarrays(5, new int[][] {{1, 2}, {2, 5}, {3, 5}}), equalTo(12L));
    }

    @Test
    void maxSubarrays3() {
        assertThat(new Solution().maxSubarrays(10, new int[][] {{10, 5}, {3, 8}}), equalTo(50L));
    }

    @Test
    void maxSubarrays4() {
        assertThat(
                new Solution().maxSubarrays(25, new int[][] {{9, 7}, {15, 7}, {4, 7}}),
                equalTo(216L));
    }
}
