class Solution {
    int[][] dp;

    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        dp = new int[n][1002];
        for (int[] it1 : dp) {
            Arrays.fill(it1, -1);
        }
        int maxi=2;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j]-nums[i]+500;
                maxi = Math.max(maxi, 2 + solve(nums, j, diff));
            }
        }
        return maxi;
    }

    private int solve(int[] nums, int i, int diff) {
        if (i == nums.length) {
            return 0;
        }
        if (dp[i][diff] != -1) {
            return dp[i][diff];
        }
        int ans = 0;
        for (int next = i + 1; next < nums.length; next++) {
            if (nums[next] - nums[i] + 500 == diff)
                ans = Math.max(ans, 1 + solve(nums, next, diff));
        }
        return dp[i][diff] = ans;

    }
}