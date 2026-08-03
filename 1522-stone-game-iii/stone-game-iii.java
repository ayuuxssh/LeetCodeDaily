class Solution {
    int[] dp;

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int sum = 0;
            int ans = Integer.MIN_VALUE;
            for (int index = i; index <= Math.min(n - 1, i + 2); index++) {
                sum += stoneValue[index];
                int take = sum - dp[index + 1];
                ans = Math.max(ans, take);
            }
            dp[i] = ans;

        }
        int diff = dp[0];
        System.out.println(diff);
        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }
}