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
        if (head == null) return null;
        ListNode temp = null;
        ListNode curr = head;
        ListNode prev = temp;
        while(curr != null) {
            prev = temp;
            temp = curr;
            ListNode aux = curr.next;
            curr.next = prev;
            curr = aux;
        }
        head = temp;
        return head;
    }
}