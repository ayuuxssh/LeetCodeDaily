class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        Set<Integer>prev = new HashSet<>();
        Set<Integer>result = new HashSet<>();
        for(int i=0;i<n;i++)
        { 
        Set<Integer>curr = new HashSet<>();
        curr.add(arr[i]);
            for(int it:prev)
            {
                int bitwise = (it|arr[i]);
                curr.add(bitwise);
            }
       result.addAll(curr);
            prev = curr;
        }
        return result.size();
    }
}