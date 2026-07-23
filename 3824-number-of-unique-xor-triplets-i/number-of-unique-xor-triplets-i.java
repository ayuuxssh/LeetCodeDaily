class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n<3)
        {
            return n;
        }
        if(n==3)
        {
            return 4;
        }
        int bitlength = Integer.toBinaryString(n).length();
        return (1<<bitlength);
    }
}