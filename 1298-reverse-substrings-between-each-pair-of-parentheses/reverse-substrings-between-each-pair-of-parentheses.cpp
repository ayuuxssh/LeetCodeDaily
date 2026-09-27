class Solution {
public:
    string reverseParentheses(string s) {
        stack<char> st;

        for (char c : s) {
            if (c == ')') {
                string temp = "";
                while (!st.empty() && st.top() != '(') {
                    temp += st.top();
                    st.pop();
                }
                // Pop the '('
                st.pop();
                
                // Push the reversed string back to the stack
                for (char ch : temp) {
                    st.push(ch);
                }
            } else {
                st.push(c);
            }
        }

        // Reconstruct final string
        string result = "";
        while (!st.empty()) {
            result += st.top();
            st.pop();
        }
        reverse(result.begin(), result.end());

        return result;
    }
};