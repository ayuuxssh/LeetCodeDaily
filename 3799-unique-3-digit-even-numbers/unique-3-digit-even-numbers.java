class Solution {
    public int totalNumbers(int[] digits) {
        HashSet<String> st = new HashSet<>();
        boolean[]used = new boolean[digits.length];
        int[] count = new int[1];
        solve(digits, used, new StringBuilder(), st, count);
        return count[0];
    }

    private void solve(int[] digits, boolean[]used, StringBuilder sb, HashSet<String> st, int[] count) {
        if (sb.length() == 3) {
            int val = Integer.parseInt(sb.toString());
            if (val%2==0 && !st.contains(sb.toString())) {
                    count[0]++;
                    st.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            if (used[i])
                continue;
            if (sb.length() == 0 && digits[i] == 0) {
                continue;
            }
            used[i]=true;
            sb.append((char) (digits[i] + '0'));
            solve(digits, used, sb, st, count);
            sb.deleteCharAt(sb.length() - 1);
            used[i]=false;
        }

    }
}