class Solution {
    boolean[] dp;

    public boolean winnerSquareGame(int n) {
        dp = new boolean[n + 1];
        dp[0] = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!dp[i - (j * j)]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}