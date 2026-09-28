class Solution {
    public double myPow(double x, int n) {
        long N =(long)n;
        boolean neg = false;
        if (N < 0) {
            neg = true;
            N = -N;
        }
        double ans = 1.0;
        while (N != 0) {
            if ((N&1) == 0) {
                x = x * x;
                N = N / 2;
            } else {
                N--;
                ans = ans * x;
            }
        }
        if (neg) {
            return 1.0 / ans;
        }
        return ans;
    }
}