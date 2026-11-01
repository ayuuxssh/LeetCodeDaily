class Solution {
public:
    int minMoves(vector<int>& nums) {
   int ops=0;
   
   int mini =*min_element(nums.begin(),nums.end());
   for(auto it:nums)
   {
    ops+=(it-mini);
   }
   return ops;
    }
};