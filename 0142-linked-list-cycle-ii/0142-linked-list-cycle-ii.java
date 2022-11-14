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
        // HashSet<ListNode> h = new HashSet<>();
        // if (head == null) return null;
        // ListNode curr = head;
        // while (true) {
        //     if (h.contains(head)) return head;
        //     h.add(head);
        //     if (head.next == null) return null;
        //     head = head.next;
        // }
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        
        while (true) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow.next != null) {
                slow = slow.next;
            } else {
                return null;
            }
            if (fast == slow) {
                break;
            }
        }
        
        ListNode entry = head;
        while (entry != slow) {
            entry = entry.next;
            slow = slow.next;
        }
        
        return entry;
    }
}