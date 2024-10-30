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

    public static ListNode  mid(ListNode head){
        ListNode temp = head;

        ListNode slow = temp;
        ListNode fast = temp;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // Note: We need to return the prev value i.e before mid
        return slow;
    }

    public static ListNode mergeTwoSortedLL(ListNode list1, ListNode list2){
        ListNode ans = null;
        ListNode t = null;

        ListNode h1 = list1;
        ListNode h2 = list2;

        if(h1.val < h2.val){
            ans = h1;
            t = h1;
            h1 = h1.next;
        }else{
            ans = h2;
            t = h2;
            h2 = h2.next;
        }

        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                t.next = h1;
                t = t.next;

                h1 = h1.next;
            }else{
                t.next = h2;
                t = t.next;

                h2 = h2.next;
            }
        }

        // If any one of the ll becomes null
        if(h1 != null){
            t.next = h1;
        }

        if(h2 != null){
            t.next = h2;
        }

        return ans;
    }

    public static ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }

        ListNode m = mid(head);
        ListNode h2 = m.next;
        // Break the list into two parts
        m.next = null;

        ListNode list1 = mergeSort(head);
        ListNode list2 = mergeSort(h2);

        return mergeTwoSortedLL(list1, list2);
    }

    public static ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }

        return mergeSort(head);
    }
}