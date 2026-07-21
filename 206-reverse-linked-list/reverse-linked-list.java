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
    public ListNode reverseList(ListNode head) {
        Stack<Integer>st = new Stack<>();
        if(head==null || head.next== null)
        {
            return head;
        }
        ListNode temp = head;
        while(temp!=null)
        {
            st.add(temp.val);
            temp = temp.next;
        }
        ListNode temp1 = head;
        while(temp1!=null)
        {
            temp1.val = st.peek();
            st.pop();
            temp1 = temp1.next;
        }
        return head;
    }
}