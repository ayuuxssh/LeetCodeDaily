class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;
        long []prefix = new long[n];
        prefix[0]=tasks[0];
        for(int i=1;i<n;i++)
        {
            prefix[i]=prefix[i-1]+tasks[i];
        }
        int[] ans = new int[m];
        long rem =0;
        for (int i = 0; i < m; i++) {
            long shift = rem+shifts[i];
            if(prefix[n-1]<=shift)
            {
                ans[i]=0;
                rem=0;
            }
            else
            {
           int idx = Arrays.binarySearch(prefix,shift);
           int complete;
           if(idx>=0)
           {
           complete =idx+1;
           }
           else
           {
            int insert =-idx-1;
            complete =insert;
           }
           ans[i]= n-complete;
           rem = shift;
        }
        }
        return ans;
    }
}