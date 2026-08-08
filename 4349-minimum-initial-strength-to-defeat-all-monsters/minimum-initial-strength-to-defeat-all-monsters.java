class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        int n = monsters.length;
        long []diff = new long[n+1];
        Arrays.fill(diff,0);
        for(int []it:boosts)
        {
            int u = it[0];
            int v = it[1];
            int val = it[2];
            diff[u]+=val;
            diff[v+1]-=val;
        }
        for(int i=1;i<n;i++)
        {
            diff[i]+=diff[i-1];
        }
        long low = 0;
        long ans = 0L;
        long high =(long)1e18;
        while(low<=high)
        {
            long mid = low+(high-low)/2;

            if(possible(mid,diff,monsters))
            {
                ans= mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return ans;
    }
    private boolean possible(long k, long[]diff,int []monsters )
    {
        int n = monsters.length;
        for(int i=0;i<n;i++)
        {
            if(k+diff[i]>=monsters[i])
            {
                k-=monsters[i];
                if(k<0)
                {
                    k=0;
                }
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}