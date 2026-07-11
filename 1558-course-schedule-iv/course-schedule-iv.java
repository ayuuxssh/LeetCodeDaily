class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int[] it : prerequisites) {
            indegree[it[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Set<Integer>>st = new ArrayList<>();
                for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
            st.add(new HashSet<>());
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        for (int[] it : prerequisites) {
            int u = it[0];
            int v = it[1];
            adj.get(u).add(v);
        }
        
        while (!q.isEmpty()) {
            int node = q.poll();
    
            for (int it : adj.get(node)) {
                st.get(it).add(node);
                st.get(it).addAll(st.get(node));
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] it : queries) {
            int l = it[0];
            int r = it[1];
            ans.add(st.get(r).contains(l));
            }
        return ans;
    }
}