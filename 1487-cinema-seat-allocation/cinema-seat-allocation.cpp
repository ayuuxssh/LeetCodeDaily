class Solution {
public:
    int maxNumberOfFamilies(int n, vector<vector<int>>& reservedSeats) {
        unordered_map<int, int> mp;
        for (auto it : reservedSeats) {
            int row = it[0];
            int col = it[1];
            mp[row] |= (1 << col);
        }

        int result = (n - mp.size()) * 2;
        int grpA = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int grpB = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int grpC = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);
        for (auto& it : mp) {
            bool grpA1 = (it.second & grpA) == 0;
            bool grpB1 = (it.second & grpB) == 0;
            bool grpC1 = (it.second & grpC) == 0;

            if (grpA1 && grpC1) {
                result += 2;
            } else if (grpA1 || grpB1 || grpC1) {
                result += 1;
            }
        }
        return result;
    }
};