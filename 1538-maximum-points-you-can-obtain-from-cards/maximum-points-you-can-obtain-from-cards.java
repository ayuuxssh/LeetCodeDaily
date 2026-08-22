class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int total = 0;
        for (int it : cardPoints) {
            total += it;
        }

        int x = n - k;
        if(x==0)
        {
            return total;
        }
        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (j < n) {
            sum += cardPoints[j];
            if (j - i + 1 < x) {
                j++;
            } else {
                ans = Math.min(ans, sum);
                sum -= cardPoints[i];
                i++;
                j++;
            }
        }
        return total - ans;
    }
}