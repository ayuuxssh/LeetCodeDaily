class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = sum(nums,goal);
        int ans1 = sum(nums,goal-1);
        return ans-ans1;
    }
    private int sum(int []nums,int goal)
    {
        if(goal<0)
        {
            return 0;
        }
           int n = nums.length;
        int sum = 0;
        int i = 0;
        int j = 0;
        int ans = 0;
        while (j < n) {
            sum += nums[j];
            if (sum <= goal) {
                ans += j - i + 1;
                j++;
            } else {
                while (sum > goal) {
                    sum -= nums[i];
                    i++;
                }
                ans += j - i + 1;
                j++;
            }
        }
        return ans;
    }
}