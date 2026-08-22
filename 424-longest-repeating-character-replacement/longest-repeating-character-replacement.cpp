class Solution {
public:
    int characterReplacement(string s, int k) {
        int n = s.length();
        vector<int> freq(26, 0);
        int i = 0;
        int j = 0;
        int ans = 0;
        while (j < n) {
            freq[s[j] - 'A']++;
            int maxi = 0;
            for (int w = 0; w < 26; w++) {
                maxi = max(maxi, freq[w]);
            }
            if ((j - i + 1) - maxi <= k) {
                ans = max(ans, j - i + 1);
                j++;
            } else {
                while ((j - i + 1) - maxi > k) {
                    freq[s[i] - 'A']--;
                    i++;
                    int maxi1 = 0;
                    for (int w = 0; w < 26; w++) {
                        maxi1 = max(maxi1, freq[w]);
                    }
                    maxi = maxi1;
                }
                j++;
            }
        }
        return ans;
    }
};