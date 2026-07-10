class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // 1. Extract unique sorted values
        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);
        
        List<Integer> S = new ArrayList<>();
        S.add(sortedNums[0]);
        for (int i = 1; i < n; i++) {
            if (sortedNums[i] != sortedNums[i - 1]) {
                S.add(sortedNums[i]);
            }
        }
        
        int m = S.size();
        
        // 2. Build connectivity prefix array (to quickly identify unbridgeable gaps)
        int[] pref = new int[m];
        for (int i = 1; i < m; i++) {
            // If the gap is strictly greater than maxDiff, it's a break in connectivity
            pref[i] = pref[i - 1] + (S.get(i) - S.get(i - 1) > maxDiff ? 1 : 0);
        }
        
        // 3. Build Binary Lifting Table (up[i][k])
        int LOG = 20; // 2^19 > 10^5, sufficient for standard max constraints
        int[][] up = new int[m][LOG];
        
        // Base case: k = 0 (Furthest jump in 1 step)
        for (int i = 0; i < m; i++) {
            long target = (long) S.get(i) + maxDiff; // Use long to prevent integer overflow
            int low = i, high = m - 1, best = i;
            
            // Binary search to find the rightmost index <= target
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (S.get(mid) <= target) {
                    best = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            up[i][0] = best;
        }
        
        // DP transitions for k > 0 (Furthest jump in 2^k steps)
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < m; i++) {
                up[i][k] = up[up[i][k - 1]][k - 1];
            }
        }
        
        // 4. Answer Queries in O(log N) time each
        int q = queries.length;
        int[] ans = new int[q];
        
        for (int i = 0; i < q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            // Trivial case: same node
            if (u == v) {
                ans[i] = 0;
                continue;
            }
            
            int valU = nums[u];
            int valV = nums[v];
            
            // Get their compressed positions in the unique sorted list 'S'
            int L = Collections.binarySearch(S, Math.min(valU, valV));
            int R = Collections.binarySearch(S, Math.max(valU, valV));
            
            // If there's any gap between L and R in the prefix sum, they are disconnected
            if (pref[R] - pref[L] > 0) {
                ans[i] = -1;
                continue;
            }
            
            // If nodes share the exact same value but are different nodes
            // The difference is 0 (which is <= maxDiff), so distance is 1
            if (L == R) {
                ans[i] = 1;
                continue;
            }
            
            // Jump using binary lifting greedily
            int dist = 0;
            for (int k = LOG - 1; k >= 0; k--) {
                // If taking 2^k steps keeps us strictly before the destination
                if (up[L][k] < R) {
                    L = up[L][k];        // Take the jump
                    dist += (1 << k);    // Add 2^k to our distance
                }
            }
            
            // After the loop, L is exactly one jump away from reaching or exceeding R
            ans[i] = dist + 1;
        }
        
        return ans;
    }
}