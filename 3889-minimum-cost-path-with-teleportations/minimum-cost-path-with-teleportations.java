class Solution {

    public int minCost(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int maxVal = 0;

        // Collect cells by value
        Map<Integer, List<Integer>> posByVal = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                posByVal.computeIfAbsent(val, x -> new ArrayList<>())
                        .add(i * n + j);
                maxVal = Math.max(maxVal, val);
            }
        }

        final int INF = Integer.MAX_VALUE / 2;
        int size = m * n;

        // dp[t][pos] = minimum cost to reach pos using exactly t teleports
        int[][] dp = new int[k + 1][size];
        for (int t = 0; t <= k; t++) {
            Arrays.fill(dp[t], INF);
        }

        // Base: no teleports, only normal grid DP
        dp[0][0] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int pos = i * n + j;
                if (i > 0) {
                    dp[0][pos] = Math.min(dp[0][pos],
                        dp[0][(i - 1) * n + j] + grid[i][j]);
                }
                if (j > 0) {
                    dp[0][pos] = Math.min(dp[0][pos],
                        dp[0][i * n + j - 1] + grid[i][j]);
                }
            }
        }

        // Fill DP with teleports
        for (int t = 1; t <= k; t++) {
            // Build suffix min from previous dp (t - 1)
            int[] suffixMin = new int[maxVal + 2];
            Arrays.fill(suffixMin, INF);

            int best = INF;
            // Values from max down to 0
            for (int v = maxVal; v >= 0; v--) {
                if (posByVal.containsKey(v)) {
                    for (int pos : posByVal.get(v)) {
                        best = Math.min(best, dp[t - 1][pos]);
                    }
                }
                suffixMin[v] = best;
            }

            // Now compute dp[t][pos] with teleports and normal moves
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int pos = i * n + j;

                    // Either not teleport here
                    dp[t][pos] = Math.min(dp[t][pos], dp[t - 1][pos]);

                    // Or teleport here
                    int val = grid[i][j];
                    dp[t][pos] = Math.min(dp[t][pos], suffixMin[val]);

                    // Normal moves right/down
                    if (i > 0) {
                        dp[t][pos] = Math.min(dp[t][pos],
                                dp[t][(i - 1) * n + j] + val);
                    }
                    if (j > 0) {
                        dp[t][pos] = Math.min(dp[t][pos],
                                dp[t][i * n + j - 1] + val);
                    }
                }
            }
        }

        return dp[k][m * n - 1];
    }
}
