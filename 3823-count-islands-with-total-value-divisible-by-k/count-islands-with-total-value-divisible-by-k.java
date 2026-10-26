class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int count =0;
        boolean [][]vis = new boolean[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
               if( grid[i][j]!=0 && !vis[i][j] && bfs(grid,i,j,vis,k))
               {
                count++;
               }
            }
        }
        return count;
    }
    private boolean bfs(int [][]grid,int i,int j, boolean [][]vis,int k)
    {
      vis[i][j]=true;
      Queue<int[]>q = new LinkedList<>();
      q.add(new int[]{i,j});
      int n = grid.length;
      int m = grid[0].length;
      int []dirrow = {1,-1,0,0};
      int []dircol = {0,0,-1,1};
       long sum =grid[i][j];
      while(!q.isEmpty())
      {
        int []rc = q.poll();
        int row = rc[0];
        int col = rc[1];
       for(int w=0;w<4;w++)
       {
        int nr = row+dirrow[w];
        int nc = col+dircol[w];
        if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]!=0 && !vis[nr][nc])
        {
          sum+=grid[nr][nc];
          vis[nr][nc]=true;
          q.add(new int[]{nr,nc});
        }
       }
      }
 
      if(sum%k==0 )
      {
        return true;
      }

      return false;
    }
}