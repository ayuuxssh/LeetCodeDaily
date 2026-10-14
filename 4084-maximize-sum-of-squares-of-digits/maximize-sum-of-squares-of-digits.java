class Solution {
    public String maxSumOfSquares(int num, int sum) {
        StringBuilder sb = new StringBuilder();
        if( sum>9*num)
        {
          return "";
        }
        while(num>0)
        {
          int digit = Math.min(9,sum);
          sum-=digit;
          num--;
          sb.append(digit);
        }
        return sb.toString();
    }
}