class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int med =  (n-1)/2;
        int ele = nums[med];
        int ops=0;
        for(int i=0;i<n;i++)
        {
            ops+=Math.abs(nums[i]-ele);
        }
        return ops;
    }
}