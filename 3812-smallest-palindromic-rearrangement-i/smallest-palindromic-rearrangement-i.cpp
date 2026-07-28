class Solution {
public:
    string smallestPalindrome(string s) {
        vector<int> freq(26, 0);
        int n = s.length();
        for (auto it : s) {
            freq[it - 'a']++;
        }
        string new1 = "";
        string new2 = "";
        string new3 = "";
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                new3 += (i + 'a');
                freq[i]--;
                break;
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 1; j <= freq[i]; j += 2) {
                new1 += (i + 'a');
                new2 += (i + 'a');
            }
        }
        reverse(new2.begin(), new2.end());
        if (n % 2 == 0) {
            return new1 + new2;
        } else {
            return new1 + new3 + new2;
        }
    }
};