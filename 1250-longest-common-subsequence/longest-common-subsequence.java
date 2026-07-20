class Solution {
    int [][]dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[n+1][m+1];
         for(int []it:dp)
         {
            Arrays.fill(it,-1);
         }
        return generate(n-1,m-1,text1,text2);
    }
    private int generate(int i,int j,String s,String st)
    {
        if(i<0 || j<0)
        {
            return 0;
        }
        if(dp[i+1][j+1]!=-1)
        {
            return dp[i+1][j+1];
        }
        if(s.charAt(i)==st.charAt(j))
        {
            return 1+generate(i-1,j-1,s,st);
        }
        return dp[i+1][j+1]=Math.max(generate(i-1,j,s,st),generate(i,j-1,s,st));
    }
}