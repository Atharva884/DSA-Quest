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
    public int sizeOfLL(ListNode head){
        int size = 0;

        while(head != null){
            size++;
            head = head.next;
        }

        return size;
    }

    public ListNode reverse(ListNode temp){
        ListNode head = temp;

        ListNode r = null;
        ListNode p = temp;

        while(p != null){
            ListNode q = p.next;
            p.next = r;
            r = p;
            p = q;
        }

        head = r;

        return head;
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode temp = head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevGrpEnd = dummy;

        int size = sizeOfLL(temp);
        int grps = size / 2;

        while(grps != 0){
            ListNode cur = prevGrpEnd.next;
            ListNode p1 = cur;

            int i=1;
            while(p1 != null && i < 2){
                p1 = p1.next;
                i++;
            }
            
            ListNode nextGrpStart = p1.next;
            p1.next = null;

            ListNode rev = reverse(cur);
            prevGrpEnd.next = rev;
            cur.next = nextGrpStart;

            prevGrpEnd = cur;            

            grps--;
        }

        return dummy.next;
    }
}