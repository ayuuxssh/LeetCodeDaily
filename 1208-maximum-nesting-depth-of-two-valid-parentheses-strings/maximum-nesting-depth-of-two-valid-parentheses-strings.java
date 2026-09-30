class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];
        int count = 0;
        int[] rem = new int[n];
        int ans1 = 0;
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                count++;
                rem[i]=count;
                ans1 = Math.max(count, ans1);
            } else {
                rem[i]=count;
                count--;
            }
        }
        for (int i = 0; i < n; i++) {
            if (rem[i] % 2 == 0) {
                ans[i] = 0;
            } else {
                ans[i] = 1;
            }
        }
        return ans;
    }
}