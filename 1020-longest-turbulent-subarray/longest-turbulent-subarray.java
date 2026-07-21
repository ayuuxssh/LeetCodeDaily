class Solution {
    int n;
int [][]dp;
    public int maxTurbulenceSize(int[] arr) {
        n = arr.length;
        if (n == 1) {
            return 1;
        }
        dp = new int[n][2];
        for(int []it:dp)
        {
            Arrays.fill(it,-1);
        }
        int maxi = 1;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, count(arr, i, 0));
            maxi = Math.max(maxi, count(arr, i, 1));
        }
        return maxi;
    }

    private int count(int[] arr, int index, int up) {
        if (index == 0) {
            return 1;
        }
        int take=1;
        if(dp[index][up]!=-1)
        {
            return dp[index][up];
        }
        if (up == 0) {
            if (arr[index - 1] < arr[index]) {
                take = 1 + count(arr, index - 1, 1);
            }
        } else {
            if (arr[index - 1] > arr[index]) {
                take = 1 + count(arr, index - 1, 0);
            }
        }
            return dp[index][up]=take;
        
    }

}