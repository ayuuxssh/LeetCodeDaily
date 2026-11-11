class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long costex1=Long.MAX_VALUE;
        long costex2=Long.MAX_VALUE;
           if(need1>need2)
           {
            long extra = need1-need2;
             costex1 = (long)((long)cost1*extra+(long)costBoth*need2);
           }
           else
           {
            long extra = need2-need1;
            costex2 = (long)(cost2*extra+(long)costBoth*need1);
           }
           
        return Math.min((long)((long)cost1*need1*1L+(long)cost2*need2*1L),Math.min((long)1L*costBoth*Math.max(need1,need2),Math.min(costex1,costex2)));
    }
}