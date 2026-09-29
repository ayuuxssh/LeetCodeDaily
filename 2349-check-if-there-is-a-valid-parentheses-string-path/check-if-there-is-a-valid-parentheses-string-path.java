class Solution {
    int n,m;
    int [][][]dp;
    public boolean hasValidPath(char[][] grid) {
         n = grid.length;
         m = grid[0].length;
        int [][]grid1 = new int[n][m];
        dp = new int [n][m][200+n+m];
        for(int [][]it:dp)
        {
            for(int []it1:it)
            {
                Arrays.fill(it1,-1);
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]=='(')
                {
                    grid1[i][j]=1;
                }
                else
                {
                    grid1[i][j]=-1;
                }
            }
        }
        return solve(grid1,0,0,0);
    }
    private boolean solve(int [][]grid,int i,int j,int sum)
    {
         if(i>=n || j>=m)
        {
            return false;
        }
        sum+=grid[i][j];
        if(sum<0)
        {
            return false;
        }
        if(i==n-1 && j== m-1)
        {
            if(sum==0)
            {
                return true;
            }
            return false;
        }
       
        if(dp[i][j][200+sum]!=-1)
        {
            return dp[i][j][200+sum]==1?true:false;
        }

        boolean down = solve(grid,i+1,j,sum);
        boolean right = solve(grid,i,j+1,sum);
        dp[i][j][200+sum]= (down||right)?1:0;
        return (down||right);
    }
}