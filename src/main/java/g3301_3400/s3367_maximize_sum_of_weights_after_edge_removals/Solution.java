package g3301_3400.s3367_maximize_sum_of_weights_after_edge_removals;

// #Hard #Dynamic_Programming #Depth_First_Search #Tree
// #2024_12_03_Time_104_ms_(91.49%)_Space_147.1_MB_(58.51%)

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

@SuppressWarnings("unchecked")
public class Solution {
    private List<int[]>[] adj;
    private int k;

    public long maximizeSumOfWeights(int[][] edges, int k) {
        int n = edges.length + 1;
        adj = new List[n];
        this.k = k;
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(e);
            adj[e[1]].add(e);
        }
        return dfs(0, -1)[1];
    }

    private long[] dfs(int v, int parent) {
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int[] e : adj[v]) {
            int w = e[0] == v ? e[1] : e[0];
            if (w == parent) {
                continue;
            }
            long[] res = dfs(w, v);
            long max = Math.max(e[2] + res[0], res[1]);
            sum += max;
            pq.add(max - res[1]);
        }
        long[] res = new long[2];
        while (pq.size() > k) {
            sum -= pq.poll();
        }
        res[1] = sum;
        while (pq.size() > k - 1) {
            sum -= pq.poll();
        }
        res[0] = sum;
        return res;
    }
}
