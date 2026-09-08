class Solution {
    public int countCommas(int n) {
        int x =(int) (Math.log10(n)+1);
        if(x<4)
        {
            return 0;
        }
        return n-1000+1;
    }
}