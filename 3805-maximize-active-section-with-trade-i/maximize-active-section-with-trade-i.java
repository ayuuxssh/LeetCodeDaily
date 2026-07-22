class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int count1=0;
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='1')
            {
                count1++;
            }
        }
        List<Integer>list = new ArrayList<>();
        int count=0;
        int k=0;
        while(k<n)
        {
           int start = k;
           while(k<n && s.charAt(start)==s.charAt(k))
           {
            k++;
           }
           if(s.charAt(start)=='0')
           {
            list.add(k-start);
           }
        }
        // for(int it:list)
        // {
        // System.out.println(it);
        // }
        int ans=0;
      for(int i=0;i<list.size()-1;i++)
      {
        ans = Math.max(ans,list.get(i)+list.get(i+1));
      }
        return ans+count1;
    }
}