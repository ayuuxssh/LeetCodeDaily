class Solution {
    int mod = (int) 1e9 + 7;

    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        int[] number_of_odd = new int[n];
        int[] number_of_even = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }
        number_of_odd[0] = 0;
        number_of_even[0] = 0;
        for (int i = 1; i < n; i++) {
            number_of_odd[i] = number_of_odd[i - 1] + ((prefix[i - 1]) % 2 == 1 ? 1 : 0);
        }
        for (int i = 1; i < n; i++) {
            number_of_even[i] = number_of_even[i - 1] + ((prefix[i - 1]) % 2 == 0 ? 1 : 0);
        }
        // for(int it:number_of_even)
        // {
        //     System.out.println(it);
        // }
        //  for(int it:number_of_odd)
        // {
        //     System.out.println(it);
        // }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (prefix[i] % 2 == 1) {
                ans = (ans + 1) % mod;
                ans = (ans + number_of_even[i]) % mod;
            } else {
                ans = (ans + number_of_odd[i]) % mod;
            }
            // System.out.println(ans);
        }
        return ans;
    }
}