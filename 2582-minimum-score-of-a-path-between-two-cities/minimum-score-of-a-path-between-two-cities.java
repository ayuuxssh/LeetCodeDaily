class Solution {
    class DisjointSet {
        int[] parent;
        int[] minEdge;

        DisjointSet(int n) {
            parent = new int[n + 1];
            minEdge = new int[n + 1];
            Arrays.fill(minEdge, Integer.MAX_VALUE);
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }
        public int Ultp(int node)
        {
            if(parent[node]== node)
            {
                return node;
            }
            return parent[node] = Ultp(parent[node]);
        }
        public void union(int u,int v,int weight)
        {
            int pu = Ultp(u);
            int pv = Ultp(v);
            if(pu==pv)
            {
                minEdge[pu]= Math.min(minEdge[pu],weight);
            }
       else
       {
        parent[pv]=pu;
            minEdge[pu] = Math.min(Math.min(minEdge[pu],minEdge[pv]),weight);
        }
    }
    }

    public int minScore(int n, int[][] roads) {
       DisjointSet ds = new DisjointSet(n);
       for(int []it:roads)
       {
        int u = it[0];
        int v = it[1];
        int wt = it[2];
            ds.union(u,v,wt);
       }

       return ds.minEdge[ds.Ultp(1)];
    }
}