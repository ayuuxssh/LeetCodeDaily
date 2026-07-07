class Solution {
    int n ;
    int [][][]dp;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[n][n+1][2];
        for(int [][]it:dp)
        {
            for(int []it1:it)
            Arrays.fill(it1,-1);
        }
        return alice(1,0,1,piles);
    }
    private int alice(int person,int index,int m,int[]piles)
    {
        if(index>=n)
        {
            return 0;
        }
   if(dp[index][m][person]!=-1)
   {
    return dp[index][m][person];
   }
        int stones =0;
        int result =(person==1)?-1:Integer.MAX_VALUE;

        for(int x=1;x<=2*m;x++)
        {
            if(index+x-1<n)
            {
            stones+=piles[index+x-1];
            }
            if(person==1)
            {
                result = Math.max(result,stones+alice(0,index+x,Math.max(m,x),piles));
           
            }
            else
            {
                result = Math.min(result,alice(1,index+x,Math.max(m,x),piles));
            }
        }
        return dp[index][m][person]=result;
    }
}