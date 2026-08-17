class Solution {
    int [][]dp;
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new int[n][n];
        for(int []it:dp)
        {
            Arrays.fill(it,-1);
        }
        int []prefixsum = new int [n];
        prefixsum[0]=stoneValue[0];
        for(int i=1;i<n;i++)
        {
            prefixsum[i]=prefixsum[i-1]+stoneValue[i];
        }
        return game(stoneValue,0,n-1,prefixsum);
    }
    private int game(int []stoneValue,int i, int j,int []prefixsum)
    {
        if(i==j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
         int sum =0;
         int result =0;
        for(int k= i;k<j;k++)
        {
            sum+= stoneValue[k];
            int rem = prefix(k,j,prefixsum);
            if(sum>rem)
            {
            result = Math.max(result,rem+game(stoneValue,k+1,j,prefixsum));
            }
            else if(rem>sum)
            {
              result= Math.max(result,sum+ game(stoneValue,i,k,prefixsum));
            }
            else 
            {
                result = Math.max(result,Math.max(game(stoneValue,k+1,j,prefixsum),game(stoneValue,i,k,prefixsum))+sum);
            }
        }
        return dp[i][j]= result;
    }
    private int prefix(int l,int r,int []prefix)
    {
       return prefix[r]-prefix[l];
    }
}