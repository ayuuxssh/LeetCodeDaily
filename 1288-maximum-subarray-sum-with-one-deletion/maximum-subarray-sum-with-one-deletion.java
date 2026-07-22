class Solution {
    int [][]dp;
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        dp = new int[n][2];
        dp[0][0]=arr[0];
        dp[0][1]=(int)-1e9;
        ans = dp[0][0];
        for(int i=1;i<n;i++)
        {
            dp[i][0]= Math.max(arr[i],arr[i]+dp[i-1][0]);
            dp[i][1]= Math.max(dp[i-1][0],arr[i]+dp[i-1][1]);
            ans = Math.max(ans,Math.max(dp[i][0],dp[i][1]));
        }
        return ans;
    }
}