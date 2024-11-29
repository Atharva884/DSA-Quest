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

    public int pairSum(ListNode head) {
        ListNode temp = head;
        ListNode cur = temp;

        int n = sizeOfLL(temp);

        int i=0;
        while(temp != null && i < n / 2 - 1){
            temp = temp.next;
            i++;
        }

        ListNode p1 = temp.next;
        temp.next = null;

        ListNode rev = reverse(p1);

        int max = Integer.MIN_VALUE;

        while(cur != null && rev != null){
            int sum = cur.val + rev.val;
            max = Math.max(max, sum);

            cur = cur.next;
            rev = rev.next;
        }

        return max;
    }
}