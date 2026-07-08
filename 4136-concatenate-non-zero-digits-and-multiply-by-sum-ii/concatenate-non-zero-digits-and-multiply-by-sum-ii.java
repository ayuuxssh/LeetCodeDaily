class Solution {
    int mod = (int)1e9+7;
    
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int q = queries.length;
        int[] ans = new int[q];
        
        long[] prefix = new long[n];
        long[] numbers = new long[n];
        
        
        int[] nonZeroCount = new int[n]; 
        
        
        long[] power10 = new long[n + 1];
        power10[0] = 1;
        for (int i = 1; i <= n; i++) {
            power10[i] = (power10[i - 1] * 10) % mod;
        }

    
        prefix[0] = s.charAt(0) - '0';
        numbers[0] = s.charAt(0) - '0';
        nonZeroCount[0] = (s.charAt(0) != '0') ? 1 : 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                numbers[i] = numbers[i - 1];
                nonZeroCount[i] = nonZeroCount[i - 1];
            } else {
                
                numbers[i] = (10 * numbers[i - 1] + (s.charAt(i) - '0')) % mod;
                nonZeroCount[i] = nonZeroCount[i - 1] + 1; 
            }
            prefix[i] = prefix[i - 1] + (s.charAt(i) - '0');
        }

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            
            long sum = prefix[r];
            if (l > 0) {
                sum -= prefix[l - 1];
            }
            
            long temp = numbers[r];
            
            if (l > 0) {
                
                int digit = nonZeroCount[r];
                int ldigit = nonZeroCount[l - 1];
                int pow1 = digit - ldigit;
                
               
                long num = (temp - (numbers[l - 1] * power10[pow1]) % mod + mod) % mod;
                ans[i] = (int)((num * (sum % mod)) % mod);
            } else {
                ans[i] = (int)((temp * (sum % mod)) % mod);
            }
        }
        return ans;
    }
}