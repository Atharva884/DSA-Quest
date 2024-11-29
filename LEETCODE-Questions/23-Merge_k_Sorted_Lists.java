/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoSortedLists(ListNode h1, ListNode h2) {
        ListNode ans = null;
        ListNode t = null;

        if (h1.val <= h2.val) {
            ans = h1;
            t = h1;
            h1 = h1.next;
        } else {
            ans = h2;
            t = h2;
            h2 = h2.next;
        }

        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                t.next = h1;
                t = t.next;

                h1 = h1.next;
            } else {
                t.next = h2;
                t = t.next;

                h2 = h2.next;
            }
        }

        if (h1 == null) {
            t.next = h2;
        }

        if (h2 == null) {
            t.next = h1;
        }

        return ans;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;

        if (n == 0) {
            return null;
        }

        if (n == 1) {
            return lists[0] == null ? null : lists[0];
        }

        if (n == 2) {
            // Perform merging of two list
            if (lists[0] == null || lists[1] == null) {
                if (lists[0] == null) {
                    return lists[1];
                } else if (lists[1] == null) {
                    return lists[0];
                } else {
                    return null;
                }
            }

            return mergeTwoSortedLists(lists[0], lists[1]);
        }

        int i = 2;

        ListNode merged = null;

        if (lists[0] != null && lists[1] != null) {
            merged = mergeTwoSortedLists(lists[0], lists[1]);
        } else if (lists[0] != null) {
            merged = lists[0];
        } else if (lists[1] != null) {
            merged = lists[1];
        }

        while (i < n) {
            if (lists[i] != null) {
                merged = mergeTwoSortedLists(merged, lists[i]);
            }
            i++;
        }

        return merged;

    }
}