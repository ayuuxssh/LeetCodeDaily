class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low =1;
        int high =(int)1e9;
        int n= bloomDay.length;
        if(m*k>n)
        {
            return -1;
        }
        int ans =-1;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(possible(bloomDay,m,k,mid))
            {  
                // System.out.println(mid);
                ans =mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean possible(int []bloomDay,int m,int k,int mid)
    {
        int count =0;
        int bouquets=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(mid>=bloomDay[i])
            {
                count++;
            }
            else
            {
                count=0;
            }
            if(count==k)
            {
                bouquets++;
                count=0;
            }
        
        }
        return bouquets>=m;
    }
}