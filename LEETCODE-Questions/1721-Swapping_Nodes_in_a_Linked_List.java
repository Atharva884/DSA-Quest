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
    public int sizeOfLL(ListNode temp){
        int size = 0;

        while(temp != null){
            size++;
            temp = temp.next;
        }

        return size;
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode temp = head;

        int size = sizeOfLL(temp);
        int size1 = size - k;

        ListNode t1 = temp;
        ListNode t2 = temp;

        while(t1 != null && k != 1){
            k--;
            t1 = t1.next;
        }

        while(t2 != null && size1 != 0){
            size1--;
            t2 = t2.next;
        }

        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;

        return head;
    }
}