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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count =0;
        ListNode temp = head;
        while(temp!=null)
        {
            count++;
            temp= temp.next;
        }
        int x = count-n+1;
        ListNode prev = null;
        ListNode temp1 = head; 
        if(x==1)
        {
            return head.next;
        }
        int k=0;
        while(temp1!=null)
        {
            k++;
            if(k==x)
            {
                prev.next = temp1.next;
            }
            prev= temp1;
            temp1= temp1.next;
        }
        return head;
    }
}