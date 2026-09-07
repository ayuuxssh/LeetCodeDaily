class Solution {
    final int mod = (int) 1e9 + 7;
    int []dp;
    public int distinctSubseqII(String s) {
            int n = s.length();
        int []freq = new int[26];
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        int []prev =new int[n+1];
    
        for(int i=1;i<=n;i++)
        {
            int idx = s.charAt(i-1)-'a';
            prev[i]=freq[idx];
            freq[idx]=i;
        }

      return (recurse(n,prev)-1+mod)%mod;

    }

    private int recurse(int n,int []prev) {
        if (n==0) {
            return 1;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
      long total = (2*recurse(n-1,prev))%mod;
      if(prev[n]>0)
      {
      int duplicates = recurse(prev[n]-1,prev);
      total=(total-duplicates+mod)%mod;}

      return dp[n]= (int)(total%mod);
    }
}