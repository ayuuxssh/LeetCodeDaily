class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int count = 1;
        int last = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (last < nums[i]) {
                count++;
                last = nums[i];
            } else {
                ans = Math.max(ans, count);
                count = 1;
                last = nums[i];
            }
        }
        ans = Math.max(ans, count);
        int count2 = 1;
        int last2 = nums[0];
        for (int i = 1; i < n; i++) {
            if (last2 > nums[i]) {
                last2 = nums[i];
                count2++;
            } else {
                ans = Math.max(ans, count2);
                count2 = 1;
                last2 = nums[i];
            }
        }
        ans = Math.max(ans, count2);

        return ans;
    }
}