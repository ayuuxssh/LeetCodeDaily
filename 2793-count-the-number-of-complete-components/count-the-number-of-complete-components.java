class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int []it:edges)
        {
            int u = it[0];
            int v =it[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean [] vis = new boolean[n];
        int count=0;
        
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                vis[i]=true;
                int []edge = new int[1];
                int []nodes = new int[1];
                edge[0]=0;
                nodes[0]=0;
                bfs(vis,adj,edge,nodes,i);
            
                int m = nodes[0];
                int k = edge[0];
                // System.out.println(m);
                // System.out.println(k);
                if(m*(m-1)==k)
                {
                    count++;
                }
            }
        }
        return count;
    }
    private void bfs(boolean[]vis,List<List<Integer>>adj,int []edge,int []nodes,int node)
    {
      Queue<Integer>q = new LinkedList<>();
      q.add(node);
      while(!q.isEmpty())
      {
        int row = q.poll();
        nodes[0]++;
        
        for(int it:adj.get(row))
        {
            edge[0]++;
            if(!vis[it])
            {
                vis[it]=true;
                q.add(it);
            }

        }
      }
    }
}