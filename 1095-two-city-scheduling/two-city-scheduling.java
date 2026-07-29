class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->{
           int diff = a[0]-a[1];
           int diff2 = b[0]-b[1];
           return Integer.compare(diff,diff2);
        });
        int ans =0;
        int  n = costs.length;
        for(int i=0;i<n/2;i++)
        {
            ans+=costs[i][0];
        }
        for(int i=n/2;i<n;i++)
        {
            ans+=costs[i][1];
        }
        return ans;
    }
}