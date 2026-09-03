class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        Arrays.sort(nums1);
        boolean even=true;
        boolean odd= true;
        for(int i=0;i<n;i++)
            {
                if(nums1[i]%2==1)
                {
                    even = false;
                }
                else
                {
                    odd =false;
                }
            }
        if(odd || even)
            return true;
        if(nums1[0]%2==1)
        {
            return true;
        }
        return false;
    }
}