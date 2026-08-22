class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int count = 0;
        int count1 = 0;
        int count2 = 0;
        int i = 0;
        int j = 0;
        int ans = 0;
        while (j < n) {
            if (s.charAt(j) == 'a') {
                count++;
            }
            if (s.charAt(j) == 'b') {
                count1++;
            }
            if (s.charAt(j) == 'c') {
                count2++;
            }
            while (count > 0 && count1 > 0 && count2 > 0) {
                ans += (n - j);
                if (s.charAt(i) == 'a') {
                    count--;
                }
                if (s.charAt(i) == 'b') {
                    count1--;
                }
                if (s.charAt(i) == 'c') {
                    count2--;
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}