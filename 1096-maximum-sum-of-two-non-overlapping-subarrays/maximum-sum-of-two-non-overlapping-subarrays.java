class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int l = firstLen;
        int m = secondLen;
        int []prefix = new int [n];
        prefix[0]=nums[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1]+nums[i];
        }
        int ans = helper(prefix,l,m);
        int ans1 = helper(prefix,m,l);
        return Math.max(ans,ans1);
    }
        private int helper(int []prefix,int l,int m)
        {
        int i = l+m-1;
        int lans = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        while(i<prefix.length)
        {
            int left = prefix[i-m];
            if(i-m-l>=0)
            {
                left-=prefix[i-m-l];
            }
          int right = prefix[i]-prefix[i-m];
          ans = Math.max(ans,Math.max(right+left,right+lans));
          lans = Math.max(lans,left);
          i++;
        }
        return ans;
    }
}