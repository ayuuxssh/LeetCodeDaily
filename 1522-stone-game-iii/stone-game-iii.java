class Solution {
    int [][]dp;
    public String stoneGameIII(int[] stoneValue) {
        int total =0;
        int n = stoneValue.length;
        dp = new int[n][2];
        for(int []it:dp)
        {
            Arrays.fill(it,-1);
        }
        for(int it:stoneValue)
        {
            total+=it;
        }
        int player1 = game(stoneValue,0,0);
        System.out.println(player1);
        int player2 = total -player1;
        if(player1>player2)
        {
            return "Alice";
        }
        else if(player1<player2)
        {
            return "Bob";
        }
        else
        {
            return "Tie";
        }
    }
    private int game(int []stoneValue,int i,int chance)
    {
        if(i>=stoneValue.length)
        {
        return 0;
        }
        if(dp[i][chance]!=-1)
        {
            return dp[i][chance];
        }
        if(chance==0)
        {
            int sum =0;
            int ans= Integer.MIN_VALUE;
             for(int index=i;index<=Math.min(stoneValue.length-1,i+2);index++)
        {
           sum+=stoneValue[index];
            int take = sum+game(stoneValue,index+1,1);
            ans = Math.max(ans,take);
        }
            return dp[i][chance]= ans;
        }
        else
        {
        int sum =0;
        int ans1 = Integer.MAX_VALUE;
            for(int index=i;index<=Math.min(stoneValue.length-1,i+2);index++)
          {
            int take = sum+game(stoneValue,index+1,0);
            ans1 = Math.min(ans1,take);
          }
            return dp[i][chance]= ans1;
        }
    }
}    