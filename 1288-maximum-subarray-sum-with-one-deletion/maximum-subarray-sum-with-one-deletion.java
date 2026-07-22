class Solution {
    int [][]dp;
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        dp = new int[n][2];
        for(int []it:dp)
        {
            Arrays.fill(it,-1);
        }
        for(int i=0;i<n;i++)
        {
        int nodelete = count(arr,i,0);
        int onedelete = count(arr,i,1);
        ans = Math.max(ans,Math.max(nodelete,onedelete));
        }
        return ans;
    }
    private int count(int []arr,int index,int up)
    {
        if(index==0)
        {
            if(up==0)
            {
                return arr[index];
            }
            else
            {
                return (int)-1e9;
            }
        }
        if(dp[index][up]!=-1)
        {
            return dp[index][up];
        }
        if(up==0)
        {
          return dp[index][up]=Math.max(arr[index],arr[index]+count(arr,index-1,0));
        }
        else
        {
            int keep = count(arr,index-1,0);
            int nonkeep = arr[index]+count(arr,index-1,1);
            return dp[index][up]= Math.max(keep,nonkeep);
        }
    }
}