class Solution {
public:
    int totalFruit(vector<int>& fruits) {
        int n = fruits.size();
        int i = 0;
        int j = 0;
        int ans = 0;
        map<int, int> mp;
        set<int> st;
        while (j < n) {
            mp[fruits[j]]++;
            st.insert(fruits[j]);
            if (st.size() <= 2) {
                ans = max(ans, j - i + 1);
                j++;
            } else {
                while (st.size() > 2) {
                    mp[fruits[i]]--;
                    if (mp[fruits[i]] == 0) {
                        st.erase(fruits[i]);
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
};