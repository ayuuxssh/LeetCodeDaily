class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long []arr = new long[(int)1e5+1];
        for(int i=0;i<n;i++)
        {
            arr[Math.abs(nums1[i]-nums2[i])]++;
        }
        long k = k1+k2;
     for(int i=(int)1e5;i>0 && k>0 ;i--)
     {
        long countops = Math.min((long)k,(long)arr[i]);
        arr[i]-=countops;
        arr[i-1]+=countops;
        k-=countops;
        }
     long ans =0L;
     for(int i=1;i<=1e5;i++)
     {
        ans+=((long)arr[i]*(long)i*i);
     }
      return ans;
    }
}