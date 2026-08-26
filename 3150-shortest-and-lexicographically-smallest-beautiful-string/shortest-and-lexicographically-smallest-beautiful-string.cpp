class Solution {
public:
    string shortestBeautifulSubstring(string s, int k) {
        int n = s.length();
        int ans = INT_MAX;
        string st = "";
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += (s[j] - '0');
                if (sum == k) {
                    if (ans > j - i + 1) {
                        ans = j - i + 1;
                        st = s.substr(i, ans);
                    } else if (ans == j - i + 1) {
                        if (st > s.substr(i, ans)) {
                            st = s.substr(i, ans);
                        }
                    }
                }
            }
        }
        return st;
    }
};