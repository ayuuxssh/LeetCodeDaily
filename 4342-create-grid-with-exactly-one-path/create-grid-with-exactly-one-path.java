class Solution {
    public String[] createGrid(int m, int n) {
        if (m == 1) {
            String[] ans = new String[m];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.append(".");
            }
            ans[0] = sb.toString();
            return ans;
        }

        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(".");
            if (i != m - 1) {
                for (int j = 1; j < n; j++) {
                    sb.append("#");
                }
            } else {
                for (int j = 1; j < n; j++) {
                    sb.append(".");
                }
            }
            ans[i] = sb.toString();
        }
        return ans;
    }
}