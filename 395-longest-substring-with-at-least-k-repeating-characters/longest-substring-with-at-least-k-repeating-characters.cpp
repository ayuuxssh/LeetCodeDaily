class Solution {
public:
    int longestSubstring(string s, int k) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            vector<int> freq(26, 0);
            unordered_set<int> st;
            for (int j = i; j < n; j++) {
                freq[s[j] - 'a']++;
                st.insert(s[j] - 'a');
                int count = 0;
                for (int w = 0; w < 26; w++) {
                    if (freq[w] >= k) {
                        count++;
                    }
                }
                if (count == st.size()) {

                    ans = max(ans, j - i + 1);
                    // cout << ans << endl;
                }
            }
        }
        return ans;
    }
};