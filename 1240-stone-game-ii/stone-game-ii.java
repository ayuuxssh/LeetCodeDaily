class Solution {
    int n;
    int[][][] dp;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[n][n + 1][2];
      for(int i=n-1;i>=0;i--)
      {
        for(int m =n;m>=1;m--)
        {
        for(int person=0;person<=1;person++)
        {
          int stones = 0;
        int result = (person == 1) ? -1 : Integer.MAX_VALUE;

        for (int x = 1; x <= 2 * m; x++) {
            if (i+ x - 1 < n) {
                stones += piles[i + x - 1];
            }
            else
            {
                break;
            }
            if (person == 1) {
                if(i+x<n)
                {
                result = Math.max(result, stones + dp[i+x][Math.max(m,x)][0]);
                }
                else
                {
                    result = Math.max(result,stones);
                }

            } else {
                if(i+x<n)
                {
                result = Math.min(result, dp[i+x][Math.max(m,x)][1]);
                }
                else
                {
                    result = Math.min(result,0);
                }
            }
        }
         dp[i][m][person] = result;
        }
        }
      }
      return dp[0][1][1];
    }
      
}