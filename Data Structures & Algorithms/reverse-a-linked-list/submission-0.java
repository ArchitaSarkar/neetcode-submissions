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
    public ListNode reverse(ListNode curr,ListNode prev){
        if(curr==null) return prev;
        ListNode nex=curr.next;
        curr.next=prev;
        return reverse(nex,curr);

    }
    public ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;
        return reverse(curr,prev);
    }
}