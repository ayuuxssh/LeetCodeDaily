class Solution {
    public int minInsertions(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        int i = 0;
        int count = 0;
        while (i < n) {
            if (s.charAt(i) == '(') {
                st.add(s.charAt(i));
                i++;
            } else {
                if (i != n - 1) {
                    if (s.charAt(i + 1) == ')') {
                        if (st.isEmpty()) {
                            count++;
                            i += 2;
                        } else {
                            st.pop();
                            i += 2;
                        }
                    } else {
                        if (st.isEmpty()) {
                            count += 2;
                        } else {
                            st.pop();
                            count++;
                        }
                        i++;
                    }
                } else {
                    if (st.isEmpty()) {
                        count += 2;
                    } else {
                        st.pop();
                        count++;
                    }
                    i++;
                }
            }

        }

        if (!st.isEmpty()) {
            count += (st.size() * 2);
        }
        return count;
    }
}