/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode future = head.next.next;
        ListNode present = head.next;
        ListNode prev = head;
        int count = 1;
        while (future != null) {
            if ((future.val > present.val && prev.val > present.val)
                    || (future.val < present.val && prev.val < present.val)) {
                list.add(count);
            }
            prev = present;
            present = future;
            future = future.next;
            count++;
        }
        if (list.size() < 2) {
            return new int[] { -1, -1 };
        }
        int mini = Integer.MAX_VALUE;
        int maxi = list.get(list.size() - 1) - list.get(0);

        for (int i = 1; i < list.size(); i++) {
            mini = Math.min(mini, list.get(i) - list.get(i - 1));
        }
        return new int[] { mini, maxi };
    }
}