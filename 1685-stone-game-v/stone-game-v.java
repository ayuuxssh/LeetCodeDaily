class Solution {
    int [][]dp;
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n][n];
        for(int []it:dp)
        {
            Arrays.fill(it,-1);
        }
        return game(stoneValue, 0, n - 1);
    }

    private int game(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int total = 0;
        for (int w = i; w <= j; w++) {
            total += arr[w];
        }
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for (int index = i; index <j; index++) {
            sum += arr[index];
            int rem = total - sum;
            if (sum > rem) {
                int step = rem + game(arr, index+1, j);
                ans = Math.max(ans, step);
            } else if (rem > sum) {
                int step = sum + game(arr, i, index);
                ans = Math.max(ans, step);
            } else {
                int step = rem + game(arr, i, index);
                int nontake = rem + game(arr, index+1, j);
                ans = Math.max(ans, Math.max(step, nontake));
            }

        }
        return dp[i][j]=ans;
    }
}