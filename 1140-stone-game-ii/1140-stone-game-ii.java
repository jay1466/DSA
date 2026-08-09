class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];

        return solve(0, 1, piles, suffix, dp);
    }

    private int solve(int i, int M, int[] piles,
                      int[] suffix, int[][] dp) {

        int n = piles.length;

        if (i >= n) {
            return 0;
        }

        if (2 * M >= n - i) {
            return suffix[i];
        }

        if (dp[i][M] != 0) {
            return dp[i][M];
        }

        int minOpponent = Integer.MAX_VALUE;

        for (int X = 1; X <= 2 * M && i + X <= n; X++) {

            int newM = Math.max(M, X);

            int opponent = solve(
                i + X,
                newM,
                piles,
                suffix,
                dp
            );

            minOpponent = Math.min(minOpponent, opponent);
        }

        dp[i][M] = suffix[i] - minOpponent;

        return dp[i][M];
    }
}