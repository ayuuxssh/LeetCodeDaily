class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        HashMap<Integer,Integer>mp = new HashMap<>();
        mp.put(0,1);
        int sum =0;
        int ans =0;
        for(int i=0;i<n;i++)
        {
          sum+=nums[i];
          if(mp.containsKey(sum-goal))
          {
            ans+=mp.get(sum-goal);
          }
          mp.put(sum,mp.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}