class Solution {
public:
    int subarraysWithKDistinct(vector<int>& nums, int k) {
        int n = nums.size();
       int ans = getans(nums,k);
       int ans1 = getans(nums,k-1);
       return ans-ans1;
    }
    private:
    int getans(vector<int>&nums,int k)
    {
        int n = nums.size();
        if(k<0)
        {
            return 0;
        }
         unordered_set<int>st;
        map<int,int>mp;
        int i=0;
        int j=0;
        int ans=0;
        while(j<n)
        {
            mp[nums[j]]++;
            st.insert(nums[j]);
             if(st.size()<=k)
            {
                ans+=j-i+1;
                j++;
            }
            else
            {
                while(st.size()>k)
                {
                    mp[nums[i]]--;
                    if(mp[nums[i]]==0)
                    {
                        st.erase(nums[i]);
                    }
                    i++;
                }
                ans+=j-i+1;
                j++;
            }
        }
        return ans;
    }
};