class Solution {
    public int smallestNumber(int n, int t) {
        
        for(int i=n;i<=1000;i++)
        {
            int temp=i;
            int pro=1;
            while(temp!=0)
            {
                int d = temp%10;
                pro = pro*d;
                temp = temp/10;
            }
            if(pro%t==0)
            {
                return i;
            }
        }
        return -1;
    }
}