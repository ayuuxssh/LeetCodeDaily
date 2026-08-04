class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer>ans = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;
         HashSet<Integer>st = new HashSet<>();
        for(int it:nums)
        {
            maxi = Math.max(maxi,it);
            mini = Math.min(mini,it);
            st.add(it);
        }
        for(int i=mini+1;i<maxi;i++)
        {
            if(!st.contains(i))
            {
                ans.add(i);
            }
        }
       return ans;
    }
}