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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;

        ListNode temp = list1;
        int aCount = a;
        while(temp != null && a != 1){
            a--;
            temp = temp.next;
        }

        ListNode p1 = temp.next;
        temp.next = null;

        int rem = b - aCount + 1;
        while(p1 != null && rem != 0){
            rem--;
            p1 = p1.next;
        }

        ListNode p2 = p1;

        temp.next = list2;

        while(list2.next != null){
            list2 = list2.next;
        }

        list2.next = p2;

        return head;
    }
}