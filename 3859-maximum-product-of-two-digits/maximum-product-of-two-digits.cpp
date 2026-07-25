class Solution {
public:
    int maxProduct(int n) {
        string s = to_string(n);
        sort(s.begin(),s.end());
        int w = s.length();
        return (s[w-1]-'0')*(s[w-2]-'0');
    }
};