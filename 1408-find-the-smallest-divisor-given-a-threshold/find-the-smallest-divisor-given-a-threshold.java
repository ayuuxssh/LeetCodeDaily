class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low =1;
        int high = 1000000;
        int ans =0;
        while(low<=high)
        {
          int mid = low+(high-low)/2;
          if(possible(mid,nums,threshold))
          {
            ans = mid;
            high = mid-1;
          }
          else 
          {
            low = mid+1;
          }
        }
        return ans;
    }
    private boolean possible(int mid,int[]nums,int threshold)
    {
        int sum =0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=((nums[i]+mid-1)/mid);
        }

        return threshold>=sum;
    }
}