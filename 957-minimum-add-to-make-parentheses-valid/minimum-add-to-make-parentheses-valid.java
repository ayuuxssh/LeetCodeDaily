class Solution {
    public int minAddToMakeValid(String s) {
        int n =s.length();
        int count=0;
       Stack<Character>st = new Stack<>();
       for(int i=0;i<n;i++)
       {
        if(!st.isEmpty() && s.charAt(i)==')')
        {
            st.pop();
        }
        else if(st.empty() && s.charAt(i)==')')
        {
            count++;
        }
        else if(s.charAt(i)=='(')
        {
            st.add('(');
        }
       }
       count+=st.size();
       return count;
    }
}