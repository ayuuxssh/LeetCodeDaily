class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int count =0;
        int count1=0;
        if(k==1)
        {
            HashMap<Integer,Integer>mp = new HashMap<>();
            int maxi =-1;
            for(int i =0;i<n;i++)
             {
                mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
             }
             for(Map.Entry<Integer,Integer> it:mp.entrySet())
             {
                if(it.getValue()==1)
                {
                maxi = Math.max(maxi,it.getKey());
                }
             }
            return maxi;
        }
        if(n==k)
        {
            int maxi =-1;
            for(int i=0;i<n;i++)
            {
                maxi = Math.max(maxi,nums[i]);
            }
            return maxi;
        }
        for(int i=0;i<n;i++)
        {
            if(nums[i]==nums[0])
            {
                count++;
            }
            if(nums[i]==nums[n-1])
            {
                count1++;
            }
        }
        if(count>1 && count1>1)
        {
            return -1;
        }
        else if(count==1 && count1>1)
        {
            return nums[0];
        }
        else if(count1==1 && count>1)
        {
            return nums[n-1];
        }
        else
        {
            return Math.max(nums[0],nums[n-1]);
        }
    }
}