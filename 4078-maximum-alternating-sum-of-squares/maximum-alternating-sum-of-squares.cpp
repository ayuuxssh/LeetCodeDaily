class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        int n = nums.size();
        for(int i=0;i<n;i++)
        {
            nums[i]= abs(nums[i]);
        }
        sort(nums.begin(), nums.end());
        int idx = 0;
        vector<int> arr(n);
        int j = n - 1;
        while (idx < n) {
            arr[idx] = nums[j];
            idx += 2;
            j--;
        }
        idx = 1;
        while (idx < n) {
            arr[idx] = nums[j];
            j--;
            idx+=2;
        }
        long long ans = 0LL;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                ans += (arr[i] * arr[i]);
            } else {
                ans -= (arr[i] * arr[i]);
            }
        }
        return ans;
    }
};