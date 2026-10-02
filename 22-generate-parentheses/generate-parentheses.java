class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>ans = new ArrayList<>();
        recurs(n,ans,"",0,0);
        return ans;
    }
    private void recurs(int n , List<String>ans, String s,int open,int close)
    {
        if(s.length()==2*n)
        {
                ans.add(s);
            
            return;
        }
        if(open<n)
        {
        recurs(n,ans,s+'(',open+1,close);
        }
        if(close<open)
        {
                recurs(n,ans,s+')',open,close+1);
        }
    }
}