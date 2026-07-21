class Solution {
    int n;
int []dp;
    public int maxTurbulenceSize(int[] arr) {
        n = arr.length;
        if (n == 1) {
            return 1;
        }
        dp = new int[2];
        dp[0] =1;
        dp[1] =1;
        int maxi =1;
        for(int i=1;i<n;i++)
        {
            int []curr = new int[2];
            if(arr[i-1]>arr[i])
            {
                curr[1]= 1+dp[0];
                curr[0]=1;
            }
            else if(arr[i-1]<arr[i])
            {
                curr[0]=1+dp[1];
                curr[1]=1;
            }
            else
            {
                curr[0]=1;
                curr[1]=1;
            }
              maxi = Math.max(maxi, curr[0]);
            maxi = Math.max(maxi, curr[1]);
            dp=curr;
        }

        return maxi;
    
    }

}