class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] vis = new boolean[n];
        for (int[] it : invocations) {
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
        }
        vis[k]=true;
        bfs(adj, vis, k);
        boolean[]vis1 = vis;
        // for(boolean it:vis)
        // {
        //     System.out.println(it);
        // }
        boolean check = false;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                List<Integer> rem = adj.get(i);
                for (int j = 0; j < rem.size(); j++) {
                    if (vis[rem.get(j)]) {
                        vis1[rem.get(j)] = false;
                        check = true;
                    }
                }
            }
        }
        // for(boolean it:vis1)
        // {
        //     System.out.println(it);
        // }
        for (int i = 0; i < n; i++) {
            if (!vis1[i] && !check) {
                ans.add(i);
            }
            else if(check)
            {
                ans.add(i);
            }
        }
        return ans;
    }

    private void bfs(List<List<Integer>> adj, boolean[] vis, int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int nodes = q.poll();

            for (int it : adj.get(nodes)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
    }
}