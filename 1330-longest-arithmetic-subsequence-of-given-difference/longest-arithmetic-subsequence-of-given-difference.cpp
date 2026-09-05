class Solution {
public:
    int longestSubsequence(vector<int>& arr, int difference) {
        unordered_map<int,int>mp;
        int n = arr.size();
        int ans =0;
        for(auto it:arr)
        {
         ans = max(ans,1+mp[it-difference]);
         mp[it]=1+mp[it-difference];
        }
        return ans;
    }
};