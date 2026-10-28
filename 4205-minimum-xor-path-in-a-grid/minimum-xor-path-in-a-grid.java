class Solution {
    public int minCost(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int [][][]dp = new int[n][m][(int)1e4];
        for(int [][]row:dp)
        {
            for(int []col:row)
            Arrays.fill(col,-1);
        }
        return cost(grid,n-1,m-1,dp,0);
    }
    private int cost(int [][]grid,int i,int j,int[][][]dp,int xor)
    {
        if(i==0 && j==0)
        {
            return xor^grid[0][0];
        }
        if(dp[i][j][xor]!=-1)
        {
            return dp[i][j][xor];
        }
        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;
        if(j>0)
        {
         left =cost(grid,i,j-1,dp,xor^grid[i][j]);
        }
        if(i>0)
        {
         up = cost(grid,i-1,j,dp,xor^grid[i][j]);
        }
        return dp[i][j][xor]=Math.min(left,up);
    }
}