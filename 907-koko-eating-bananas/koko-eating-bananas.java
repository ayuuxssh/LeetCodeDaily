class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low =1;
        int high = (int)1e9;
        int ans =0;
        while(low<=high)
        {
            int mid = low+(high-low)/2;
            if(check(piles,h,mid))
            {
                ans=mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean check(int []piles,int h,int mid)
    {
        long sum =0;
        for(int i=0;i<piles.length;i++)
        {
            sum+=((long)(piles[i]+mid-1)/mid);
        }
        return h>=sum;
    }
}