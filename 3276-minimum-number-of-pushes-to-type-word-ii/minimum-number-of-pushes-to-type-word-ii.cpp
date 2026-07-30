class Solution {
public:
    int minimumPushes(string word) {
        vector<int> arr(26, 0);
        int n = word.size();
        for (int i = 0; i < n; i++) {
            arr[word[i] - 'a']++;
        }
        sort(arr.rbegin(), arr.rend());
        int counter = 0;
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                counter++;
                if (counter <= 8) {
                    count += arr[i];
                } else if (counter > 8 && counter <= 16) {
                    count += (arr[i] * 2);
                } else if (counter > 16 && counter <= 24) {
                    count += (arr[i] * 3);
                } else {
                    count += (arr[i] * 4);
                }
            }
        }

        return count;
    }
};