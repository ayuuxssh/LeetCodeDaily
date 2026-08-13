class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.length();
        unordered_map<char, int> mp;
        set<int> st;
        int i = 0;
        int j = 0;
        int ans = 0;
        while (j < n) {
            mp[s[j]]++;
            st.insert(s[j]);
            if (st.size() == j - i + 1) {
                ans = max(ans, j - i + 1);
                j++;
            } else {
                while (st.size() != j - i + 1) {
                    mp[s[i]]--;
                    if (mp[s[i]] == 0) {
                        st.erase(s[i]);
                    }
                    i++;
                }
                ans = max(ans, j - i + 1);
                j++;
            }
        }
        return ans;
    }
};