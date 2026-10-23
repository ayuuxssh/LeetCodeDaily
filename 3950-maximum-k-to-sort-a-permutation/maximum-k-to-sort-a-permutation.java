class Solution {
    public int sortPermutation(int[] nums) {
        int ans =-1;
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]!=i)
            {
                ans =(ans&nums[i]);
            }
        }
        return Math.max(ans,0);
    }
}