class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                nums[i] = 0;
            } else

            {
                nums[i] = 1;
            }
        }
        int ans = sum(nums, k);
        int ans1 = sum(nums, k - 1);
        return ans - ans1;
    }

    private int sum(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        int n = nums.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int ans = 0;
        while (j < n) {
            sum += nums[j];
            if (sum <= k) {
                ans += j - i + 1;
                j++;
            } else {
                while (sum > k) {
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