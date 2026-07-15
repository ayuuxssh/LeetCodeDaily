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
        dp= new int[n][maxi+1][maxi+1];
        for(int [][]it:dp)
        {
            for(int []it1:it)
            {
                Arrays.fill(it1,-1);
            }
        }
        int ans = count(nums,n-1,0,0);
        return (ans-1+mod)%mod;
    }
    private int count(int []nums,int index,int gcd1,int gcd2)
    {
        if(index<0)
        {
            if(gcd1==gcd2)
            {
                return 1;
            }
            return 0;
        }
         if(dp[index][gcd1][gcd2]!=-1)
         {
            return dp[index][gcd1][gcd2];
         }
        int skip = count(nums,index-1,gcd1,gcd2);
        int nextgcd = gcd2==0?nums[index]:gcd(gcd2,nums[index]);
        int skip1 = count(nums,index-1,gcd1,nextgcd);
        int nextgcd1 = gcd1==0?nums[index]:gcd(gcd1,nums[index]);
        int skip2 = count(nums,index-1,nextgcd1,gcd2);
        return dp[index][gcd1][gcd2]=((skip+skip1)%mod+skip2)%mod;
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