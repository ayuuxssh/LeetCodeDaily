class Solution {
    #define ll long long
public:
    long long gcdSum(vector<int>& nums) {
        int n = nums.size();
        vector<ll> prefixmax(n);
        vector<ll> prefix(n);
        prefixmax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixmax[i] = max(prefixmax[i - 1], (ll)nums[i]);
        }
        for (int i = 0; i < n; i++) {
            prefix[i] = gcd(nums[i], prefixmax[i]);
        }
        sort(prefix.begin(), prefix.end());
       
        int i = 0;
        int j = n - 1;
        ll sum = 0;
        while (i < j) {
            sum += gcd(prefix[i], prefix[j]);
            i++;
            j--;
        }
        return sum;
    }
};