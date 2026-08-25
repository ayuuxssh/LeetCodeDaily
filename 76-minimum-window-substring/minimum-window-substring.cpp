class Solution {
public:
    string minWindow(string s, string t) {
        int ans = INT_MAX;
        int start = -1;
        int m = t.length();
        int n = s.length();

        int i = 0;
        int j = 0;
        int count = 0;
        unordered_map<char, int> mp;
        for (auto& it : t) {
            mp[it]++;
        }
        while (j < n) {
            if (mp[s[j]] > 0) {
                count++;
            }
            mp[s[j]]--;
            while (count == m) {
                if (ans > j - i + 1) {
                    ans = j - i + 1;
                    start = i;
                }
                    mp[s[i]]++;
                    if (mp[s[i]] > 0) {
                        count--;
                    }
                    i++;
            }
                j++;
        }
        if (start == -1) {
            return "";
        }
        return s.substr(start, ans);
    }
};