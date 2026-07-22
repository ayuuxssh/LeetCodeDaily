class Solution {
    int []dp;
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        dp = new int[2];
        dp[0]=arr[0];
        dp[1]=(int)-1e9;
        ans = dp[0];
        for(int i=1;i<n;i++)
        {
            int []curr = new int[2];
            curr[0]= Math.max(arr[i],arr[i]+dp[0]);
            curr[1]= Math.max(dp[0],arr[i]+dp[1]);
            ans = Math.max(ans,Math.max(curr[0],curr[1]));
            dp=curr;
        }
        return ans;
    }
}