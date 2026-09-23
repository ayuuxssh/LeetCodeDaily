class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        long sum = 0;
        for (int it : nums) {
            sum += it;
        }
        long k = (long)sum - (long)x;
        if(k<0)
        {
            return -1;
        }
        int i = 0;
        int j = 0;
        int ans = 0;
        int total = 0;
        while (j < n) {
            total += nums[j];
            if (total < k) {
                j++;
            } else if (total == k) {
                ans = Math.max(ans, j - i + 1);
                 System.out.println(ans);
                j++;
            } else {
                while (total > k) {
                    total -= nums[i];
                    i++;
                }
                if(total==k)
                {
    
                    ans=Math.max(ans,j-i+1);
                }
                j++;
            }
        }
        if(ans==0 && k!=0)
        {
            return -1;
        }
        return n - ans;

    }
}