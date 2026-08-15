class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor =0;
        int count =0;
        for(int it:nums)
        {
            xor^=it;
            if(it==0)
            {
                count++;
            }
        }
        if(xor!=0)
        {
            return n;
        }
        else if(xor==0 && count==n)
        {
            return 0;
        }
        else 
        {
            return n-1;
        }
    }
}