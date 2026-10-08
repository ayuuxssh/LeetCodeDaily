class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int prev=0;
        int count =0;
        if(n<=2)
        {
            return "";
        }
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                count++;
            }
            else
            {
                count--;
            }

            if(count==0)
            {
                sb.append(s.substring(prev+1,i));
                prev=i+1;
            }
        }
        return sb.toString();
    }
}