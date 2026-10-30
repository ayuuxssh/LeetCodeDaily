class Solution {
public:
    long long maximizeSum(vector<int>& nums, int k) {
        int n = nums.size();
        long long sum =0LL;
        vector<pair<int,pair<int,int>>>ans;
        for(int i=0;i<n;i++)
        {
           string s = to_string(nums[i]);
           sort(s.rbegin(),s.rend());
           ans.push_back({nums[i]-stoi(s),{stoi(s),nums[i]}});
        }
        sort(ans.begin(),ans.end());
        for(int i=0;i<n;i++)
        {
            if(ans[i].first<0 && k>0)
            {
                sum+=ans[i].second.first;
                k--;
            }
            else
            {
                sum+=ans[i].second.second;
            }
        }
        return sum;
    }
};