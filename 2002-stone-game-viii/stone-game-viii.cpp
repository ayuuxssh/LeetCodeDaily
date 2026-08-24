class Solution {
    int dp[100001];

public:
    int stoneGameVIII(vector<int>& stones) {
        int n = stones.size();
        memset(dp, 0, sizeof(dp));
        vector<int> prefix(n);
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }
        dp[n - 1] = prefix[n - 1];
        for (int index = n - 2; index >= 1; index--) {
            int steps = prefix[index] - dp[index + 1];
            int nontake = dp[index+1];
            dp[index] = max(steps, nontake);
        }
        return dp[1];
    }
};