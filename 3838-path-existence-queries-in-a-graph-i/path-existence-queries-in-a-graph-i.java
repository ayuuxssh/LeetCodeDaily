class Solution {
   class DisjointSet{
        int [] parent;
        int []size;
        DisjointSet(int n)
        {
            parent = new int[n];
            size = new int[n];
            Arrays.fill(size,1);
            for(int i=0;i<n;i++)
            {
                parent[i]=i;
            }
        }
        int findUltp(int node)
        {
            if(parent[node]==node)
            {
                return node;
            }

            return parent[node]= findUltp(parent[node]);
        }
        void union(int u,int v)
        {
            int pu = findUltp(u);
            int pv = findUltp(v);
            if(pu==pv)
            {
                return;
            }

            if(size[pu]>size[pv])
            {
                size[pu]+=size[pv];
                parent[pv]=pu;
            }
            else
            {
                size[pv]+=size[pu];
                parent[pu]=pv;
            }
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DisjointSet ds = new DisjointSet(n);
        for(int i=0;i<n-1;i++)
        {
            if(Math.abs(nums[i]-nums[i+1])<=maxDiff)
            {
                ds.union(i,i+1);
            }
        }
        int q = queries.length;
        boolean[] ans = new boolean[q];
        for (int i = 0; i < q; i++) {
            int l = Math.min(queries[i][0], queries[i][1]);
            int r = Math.max(queries[i][0], queries[i][1]);
            if(ds.findUltp(l)== ds.findUltp(r))
            {
                ans[i]=true;
            }
            else
            {
                ans[i]=false;
            }
          
        }
        return ans;

    }
}