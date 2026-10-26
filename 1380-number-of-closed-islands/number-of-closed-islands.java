class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                if (grid[i][j] == 0 && !vis[i][j] && bfs(grid,i,j,vis)) {
                    count++;
                    
                }
            }
        }
        return count;
    }

    private boolean bfs(int[][] grid, int row, int col, boolean[][] vis) {
        vis[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[] dirrow = { 1, -1, 0, 0 };
        int[] dircol = { 0, 0, 1, -1 };
               boolean isclosed = true;
        q.add(new int[] { row, col });

        while (!q.isEmpty()) {
            int[] rc = q.poll();
            int r = rc[0];
            int c = rc[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dirrow[i];
                int nc = c + dircol[i];
                 if(nr<0 || nc<0 || nr>=n || nc>=m)
                 {
                    isclosed = false;
                 }
                 else if(grid[nr][nc]==0 && !vis[nr][nc])
                 {
                    vis[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                 }
                }
            }
            return isclosed;
        }
}