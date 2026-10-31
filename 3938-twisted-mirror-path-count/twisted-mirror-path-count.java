class Solution {
    int n;
    int m;
    int mod = (int)1e9+7;
    int [][][]dp;
    public int uniquePaths(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][3];
        for(int [][]it:dp)
        {
            for(int []it1:it)
            {
                Arrays.fill(it1,-1);
            }
        }
        return help(grid,0,0,0);
    }
    private int help(int [][]grid,int i,int j,int dir)
    {
       if(i>=n || j>=m)
       {
        return 0;
       }
       if(i==n-1 && j==m-1)
       {
        return 1;
       }
       if(dp[i][j][dir]!=-1)
       {
        return dp[i][j][dir];
       }
  int right =0;
  int down =0;
       if(dir==0)
       {
         right = help(grid,i,j+1,1);
         down = help(grid,i+1,j,2);
       }
       else if(dir ==1)
       {
        if(grid[i][j]==1)
        {
            down = help(grid,i+1,j,2);
        }
        else
        {
            right = help(grid,i,j+1,1);
            down = help(grid,i+1,j,2);
        }
       }
       else if(dir ==2)
       {
        if(grid[i][j]==1)
        {
            right = help(grid,i,j+1,1);
        }
        else
        {
            right = help(grid,i,j+1,1);
            down = help(grid,i+1,j,2);
        }
       }
       return dp[i][j][dir]=(right +down)%mod;
    }
}