class Solution {
    int []dp;
    public String stoneGameIII(int[] stoneValue) {
        int total =0;
        int n = stoneValue.length;
        dp = new int[n];
            Arrays.fill(dp,-1);
        int diff = game(stoneValue,0);
        if(diff>0)
        {
            return "Alice";
        }
        else if(diff<0)
        {
            return "Bob";
        }
        else
        {
            return "Tie";
        }
    }
    private int game(int []stoneValue,int i)
    {
        if(i>=stoneValue.length)
        {
        return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        
            int sum =0;
            int ans= Integer.MIN_VALUE;
             for(int index=i;index<=Math.min(stoneValue.length-1,i+2);index++)
        {
           sum+=stoneValue[index];
            int take = sum-game(stoneValue,index+1);
            ans = Math.max(ans,take);
        }
            return dp[i]= ans;
    }
}    