class Solution {
    public static List<Long> list = new ArrayList<>();
    public  static List<Long>listodd = new ArrayList<>();
      public  static  List<Long>listeven = new ArrayList<>();
    static {

        for (int i = 1; i <= 99999; i++) {
            String s = Integer.toString(i);
 
            String revodd = new StringBuilder(s.substring(0, s.length() - 1)).reverse().toString();
            long pal = Long.parseLong(s + revodd);
            list.add(pal);
           
            String reven = new StringBuilder(s.substring(0, s.length())).reverse().toString();
            long pal1 = Long.parseLong(s + reven);
            list.add(pal1);
        }
        Collections.sort(list);
       
        for(Long it:list)
        {
            if(it%2==0)
            {
                listeven.add(it);
            }
            else
            {
                listodd.add(it);
            }
        }
    }

    public long minOperations(int[] nums) {
        int n = nums.length;
        long ops = 0;
        for (int i = 0; i < n; i++) {// O(N)
            if (nums[i] < 10) {
                continue;
            }
            if (nums[i] % 2 == 0) {
                 long ans = Long.MAX_VALUE;
                int idx = Collections.binarySearch(listeven, (long) nums[i]);
                if (idx >= 0) {
                    continue;
                }
                idx = -idx - 1;
                // System.out.println(idx);
                if (idx < listeven.size()) {
                        ans = Math.min(ans, (listeven.get(idx) - nums[i]) / 2);
                }
                if (idx > 0) {
                        ans = Math.min(ans, (nums[i] - listeven.get(idx - 1)) / 2);
                }
                long w = nums[i] - 8;
                ans = Math.min(ans, w / 2);
                  ops += ans;
            } else {
                 long ans = Long.MAX_VALUE;
                int idx = Collections.binarySearch(listodd, (long) nums[i]);
                if (idx >= 0) {
                    continue;
                }
                idx = -idx - 1;
                // System.out.println(idx);
                if (idx < listodd.size()) {
                        ans = Math.min(ans, (listodd.get(idx) - nums[i]) / 2);
                    }
                if (idx > 0) {
                        ans = Math.min(ans, (nums[i] - listodd.get(idx - 1)) / 2);
                    }
                long w = nums[i] - 9;
                ans = Math.min(ans, w / 2);
                  ops += ans;
            }
            //  System.out.println(ans);
        }

return ops;
}

}