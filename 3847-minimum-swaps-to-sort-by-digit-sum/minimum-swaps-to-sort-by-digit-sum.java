class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        List<int[]>list = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int x = nums[i];
            int sum =0;
            while(x!=0)
            {
                int d = x%10;
                sum+=d;
                x= x/10;
            }
         list.add(new int[]{sum,nums[i],i});
        }

        Collections.sort(list,(a,b)->{
            if(a[0]==b[0])
            {
                return Integer.compare(a[1],b[1]);
            }
            return Integer.compare(a[0],b[0]);
        });
     int []targetpos = new int[n];
     for(int i=0;i<n;i++)
     {
        targetpos[list.get(i)[2]]=i;
     }
     boolean []visited = new boolean[n];
     int cycles =0;
     for(int i=0;i<n;i++)
     {
        if(!visited[i])
        {
            cycles++;
            int j=i;
            while(!visited[j])
            {
                visited[j]=true;
                j= targetpos[j];
            }
        }
     }
     return n- cycles;
    }
}