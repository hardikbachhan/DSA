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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode ptr1 = list1;
        ListNode ptr2 = list2;
        while (ptr1 != null && ptr2 != null) {
            if (ptr1.val <= ptr2.val) {
                curr.next = ptr1;
                curr = ptr1;
                ptr1 = ptr1.next;
            } else {
                curr.next = ptr2;
                curr = ptr2;
                ptr2 = ptr2.next;
            }
        }
        if (ptr1 == null && ptr2 != null) {
            curr.next = ptr2;
        }
        if (ptr1 != null && ptr2 == null) {
            curr.next = ptr1;
        }
        return dummy.next;
    }
}