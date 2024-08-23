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
    public ListNode findNthNode(ListNode head, int k){
        int count = 1;
        ListNode temp = head;

        while(temp.next != null && count != k){
            temp = temp.next;
            count++;
        }

        return temp;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;

        ListNode tail = head;
        int length = 1;

        while(tail.next != null){
            tail = tail.next;
            length++;
        }


        if(k % length == 0) return head;

        int ans = k % length;
        tail.next =  head;

        ListNode newLastNode = findNthNode(head, length-ans);
        head = newLastNode.next;
        newLastNode.next = null;

        return head;
    }
}