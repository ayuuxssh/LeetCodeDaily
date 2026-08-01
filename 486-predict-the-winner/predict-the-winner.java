class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
  return predict(nums,0,n-1,0,0,0);
    }
    private boolean predict(int []nums,int i,int j, int score1, int score2,int chance)
    {
        if(i>j)
        {
            if(score1>=score2)
            {
                return true;
            }
            return false;
        }
        boolean take1=false;
        boolean take2 = false;
        if(chance==0)
        {
            take1 = predict(nums,i+1,j,score1+nums[i],score2,1);
            take2 = predict(nums,i,j-1,score1+nums[j],score2,1);
            return take1|| take2;
        }
        else
        {
            take1 = predict(nums,i+1,j,score1,nums[i]+score2,0);
            take2 = predict(nums,i,j-1,score1,nums[j]+score2,0);
            return take1 && take2;
        }
    
    }
}