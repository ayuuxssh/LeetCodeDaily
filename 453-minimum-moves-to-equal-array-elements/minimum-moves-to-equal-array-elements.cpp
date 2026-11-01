class Solution {
public:
    int minMoves(vector<int>& nums) {
   int ops=0;
   sort(nums.begin(),nums.end());
   int mini =nums[0];
   for(auto it:nums)
   {
    ops+=(it-nums[0]);
   }
   return ops;
    }
};