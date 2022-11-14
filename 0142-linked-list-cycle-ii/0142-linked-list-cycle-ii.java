/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> h = new HashSet<>();
        if (head == null) return null;
        ListNode curr = head;
        while (true) {
            if (h.contains(head)) return head;
            h.add(head);
            if (head.next == null) return null;
            head = head.next;
        }
    }
}