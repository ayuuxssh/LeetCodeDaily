class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        int sum =nums[0];
        HashSet<Integer>st = new HashSet<>();
        int  ans = nums[0];
        for(int i=0;i<n;i++)
        {
           st.add(nums[i]);
        }
        for(int i=1;i<n;i++)
        {
            if(nums[i]==nums[i-1]+1)
            {
                sum+=nums[i];
            }
            else
            {
                break;
            }
        }
        ans = Math.max(sum,ans);
        for(int j=ans;j<=2501;j++)
        {
            if(!st.contains(j))
            {
                return j;
            }
        }
        return -1;
    }
}