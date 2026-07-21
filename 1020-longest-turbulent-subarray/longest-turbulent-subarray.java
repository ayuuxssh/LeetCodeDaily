class Solution {
    int n;
int [][]dp;
    public int maxTurbulenceSize(int[] arr) {
        n = arr.length;
        if (n == 1) {
            return 1;
        }
        dp = new int[n][2];
        dp[0][1]=1;
        dp[0][0]=1;
        for(int i=1;i<n;i++)
        {
            if(arr[i-1]>arr[i])
            {
                dp[i][1]= 1+dp[i-1][0];
                dp[i][0]=1;
            }
            else if(arr[i-1]<arr[i])
            {
                dp[i][0]=1+dp[i-1][1];
                dp[i][1]=1;
            }
            else
            {
                dp[i][0]=1;
                dp[i][1]=1;
            }
        }
        int maxi = 1;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp[i][0]);
            maxi = Math.max(maxi, dp[i][1]);
        }
        return maxi;
    
    }

}