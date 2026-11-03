class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxi = Integer.MIN_VALUE;
        for(int it:weights)
        {
         maxi= Math.max(it,maxi);
        }
        int low = maxi;
        int high = (int) 1e9;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possible(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean possible(int[] weights, int days, int mid) {
        long current = 0L;
        int currentday = 1;
        for (int i = 0; i < weights.length; i++) {
            if (current + weights[i] <= mid) {
                current += (long)weights[i];
            } else {
                currentday++;
                current = weights[i];
            }
        }
        return currentday <= days;
    }
}