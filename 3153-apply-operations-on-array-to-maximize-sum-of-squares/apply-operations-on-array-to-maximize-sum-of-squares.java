class Solution {
    int mod = (int) 1e9 + 7;

    public int maxSum(List<Integer> nums, int k) {
        int n = nums.size();

        int[] count = new int[32];
        for (int i = 0; i < 32; i++) {
            for (Integer it : nums) {
                if ((it & (1L << i)) != 0) {
                    count[i]++;
                }
            }
        }

        long res = 0;
        for (int i = 0; i < k; i++) {
            long ans = 0L;
            for (int j = 31; j >= 0; j--) {
                if (count[j] > 0) {
                    ans = (ans | (1L << j));
                    count[j]--;
                }
            }
            res = (res + ((ans * ans) % mod)) % mod;

        }
        return (int)res;
    }
}