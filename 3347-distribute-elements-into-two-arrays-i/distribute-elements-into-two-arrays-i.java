class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            if (list1.get(list1.size() - 1) > list2.get(list2.size() - 1)) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        int[] result = new int[n];
        int idx = 0;
        int i = 0;
        while (i < list1.size()) {
            result[idx++] = list1.get(i++);
        }
        int j = 0;
        while (j < list2.size()) {
            result[idx++] = list2.get(j++);
        }
        return result;
    }
}