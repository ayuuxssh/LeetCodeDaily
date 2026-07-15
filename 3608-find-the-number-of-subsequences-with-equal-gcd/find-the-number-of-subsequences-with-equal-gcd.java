class Solution {
    int mod = (int)1e9+7;
    int n ;
    int [][][]dp;
    public int subsequencePairCount(int[] nums) {
        n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int it:nums)
        {
            maxi= Math.max(maxi,it);
        }
        dp= new int[n+1][maxi+1][maxi+1];
       
       for(int i=0;i<=maxi;i++)
       {
        for(int j=0;j<=maxi;j++)
        {
            if(i==j)
            {
                dp[0][i][j]=1;
            }
        }
       }
       for(int i=1;i<=n;i++)
       {
        for(int j=maxi;j>=0;j--)
        {
            for(int k=maxi;k>=0;k--)
            {
                 int skip = dp[i-1][j][k];
        int nextgcd = k==0?nums[i-1]:gcd(k,nums[i-1]);
        int skip1 = dp[i-1][j][nextgcd];
        int nextgcd1 = j==0?nums[i-1]:gcd(j,nums[i-1]);
        int skip2 = dp[i-1][nextgcd1][k];
         dp[i][j][k]=((skip+skip1)%mod+skip2)%mod;
            }
        }
       }
        int ans = dp[n][0][0];
        return (ans-1+mod)%mod;
    }
    private int gcd(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }
}