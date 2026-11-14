class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        for(int i=l;i<=r;i++)
        {
            ans = Math.min(ans,sliding(nums,i));
        }
        if(ans==Integer.MAX_VALUE)
        {
            return -1;
        }
        return ans;
    }
    private int sliding(List<Integer>nums,int k)
    {
        int i=0;
        int j=0;
        int n = nums.size();
        int sum =0;
        int ans =Integer.MAX_VALUE;
        while(j<n)
        {
            sum+=nums.get(j);
            if(j-i+1<k)
            {
                j++;
            }
            else if(j-i+1==k)
            {
                if(sum>0)
                {
                    ans = Math.min(ans,sum);
                }
                sum-=nums.get(i);
                i++;
                j++;
            }
        }

        return ans;

    }
}