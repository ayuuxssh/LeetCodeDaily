class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] it : edges) {
            int u = it[0];
            int v = it[1];
            int wt = it[2];
            list.get(u).add(new int[] { v, wt });
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] dist = new int[n][k + 1];
        for (int[] it : dist) {
            Arrays.fill(it, (int) 1e9);
        }

        pq.add(new int[] { 0, 0, 1 });
        dist[0][1] = 0;
        while (!pq.isEmpty()) {
            int[] ans = pq.poll();
            int wt = ans[0];
            int node = ans[1];
            int identical = ans[2];
            for (int[] it : list.get(node)) {
                int v = it[0];
                int w = it[1];
                int new_id = 0;
                if (labels.charAt(node) == labels.charAt(v)) {
                    new_id= identical+1;
                }
                else
                {
                    new_id=1;
                }

                if (new_id > k) {
                    continue;
                }if (wt+ w < dist[v][new_id]) {
                    dist[v][new_id] = wt + w;
                    pq.add(new int[] { dist[v][new_id], v, new_id });
                }
            }
        }

       
        int ans = (int)(1e9);
        for(int i=0;i<=k;i++)
        {
            ans = Math.min(ans,dist[n-1][i]);
        }
        if(ans==(int)1e9)
        {
            return -1;
        }
        return ans;
    }

}