class Solution {
    public int minMoves(String[] classroom, int energy) {
        int n = classroom.length;
        char[][] grid = new char[n][];
        for (int i = 0; i < n; i++) {
            grid[i] = classroom[i].toCharArray();
        }
        int n1 = grid.length;
        int m1 = grid[0].length;
        int[] dirrow = { -1, 1, 0, 0 };
        int[] dircol = { 0, 0, 1, -1 };
        Queue<int[]> q = new LinkedList<>();
        int[][] lidx = new int[n1][m1];

        int count = 0;
        int startR = -1;
        int startC = -1;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                if (grid[i][j] == 'S') {
                    startR = i;
                    startC = j;
                }
                if (grid[i][j] == 'L') {
                    lidx[i][j] = count++;
                }
            }
        }
        int[][][] dis = new int[n1][m1][1 << count];
        for (int[][] it : dis) {
            for (int[] it1 : it) {
                Arrays.fill(it1, -(int) (1e9));
            }
        }
        dis[startR][startC][0] = energy;
        q.add(new int[] { 0, startR, startC, 0, energy });
        int target = (1 << count) - 1;
        while (!q.isEmpty()) {
            int[] ans = q.poll();
            int steps = ans[0];
            int row = ans[1];
            int col = ans[2];
            int consumed = ans[3];
            int energyrem = ans[4];

            if (consumed == target) {
                return steps;
            }
            if (energyrem == 0) {
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nr = row + dirrow[i];
                int nc = col + dircol[i];
                if (nr >= 0 && nr < n1 && nc >= 0 && nc < m1 && grid[nr][nc] != 'X') {
                    int nextenergy = energyrem - 1;
                    int nextmask = consumed;
                    if (grid[nr][nc] == 'R') {
                        nextenergy = energy;
                    } else if (grid[nr][nc] == 'L') {
                        nextmask = (nextmask | (1 << lidx[nr][nc]));
                    }
                    if (dis[nr][nc][nextmask] < nextenergy) {
                        dis[nr][nc][nextmask] = nextenergy;
                        q.add(new int[] { steps + 1, nr, nc, nextmask, nextenergy });
                    }
                }
            }
        }
        return -1;
    }
}
