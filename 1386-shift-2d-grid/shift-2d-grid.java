class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        k= k%(n*m);
        int total = n*m;
       int [][]ans = new int[n][m];
       for(int i=0;i<n;i++)
       {
        for(int j=0;j<m;j++)
        {
            int flat = i*m+j;
          int newflat = (flat+k)%total;
          int newrow = newflat/m;
          int newcol = newflat%m;
          ans[newrow][newcol]=grid[i][j];
        }
       }
       List<List<Integer>>list = new ArrayList<>();
       for(int i=0;i<n;i++)
       {
        List<Integer>res = new ArrayList<>();
        for(int j=0;j<m;j++)
        {
            res.add(ans[i][j]);
        }
        list.add(res);
       }
       return list;
    }
}