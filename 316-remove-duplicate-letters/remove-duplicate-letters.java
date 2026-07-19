class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int []last = new int[26];
        for(int i=0;i<n;i++)
        {
            last[s.charAt(i)-'a']=i;
        }
        boolean []freq = new boolean [26];
    Stack<Character>st = new Stack<>();
    
    for(int i=0;i<n;i++)
    {
        if(freq[s.charAt(i)-'a']==true)
        {
            continue;
        }
        while(!st.empty() && s.charAt(i)<st.peek() && last[st.peek()-'a']>i)
        {
             freq[st.peek()-'a']=false;
            st.pop();
        }
        st.push(s.charAt(i));
        freq[s.charAt(i)-'a']=true;
    }
StringBuilder sb = new StringBuilder();
while(!st.empty())
{
    sb.append(st.peek());
    st.pop();
}
return sb.reverse().toString();
    }
}