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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp = l1;
        ListNode temp2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int carry =0;
        while(temp!=null || temp2!=null)
        {
          int sum = carry;
          if(temp!=null)
          {
            sum+=temp.val;
          }
          if(temp2!=null)
          {
            sum+=temp2.val;
          }
          if(sum>9)
          {
            carry=1;
            curr.next = new ListNode(sum%10);
          }
          else
          {
            curr.next = new ListNode(sum);
            carry=0;
          }
          curr = curr.next;
          if(temp!=null)
          {
          temp = temp.next;
          }
          if(temp2!=null)
          {
          temp2 = temp2.next;
          }
        }
        if(carry ==1)
        {
            curr.next = new ListNode(carry);
            curr=curr.next;
        }
        return dummy.next;
    }
}