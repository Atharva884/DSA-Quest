/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    // Brute Force Approach (Using Hashset)
    // TC: O(n+m), SC: O(n)

    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // ListNode temp1 = headA;
    // ListNode temp2 = headB;

    // HashSet<ListNode> hs = new HashSet<>();

    // while(temp1 != null){
    // hs.add(temp1);
    // temp1 = temp1.next;
    // }

    // while(temp2 != null){
    // if(hs.contains(temp2)){
    // return temp2;
    // }

    // temp2 = temp2.next;
    // }

    // return null;
    // }

    // Better Approach (Using Flyod Cycle)
    // TC: O(n+m), SC: O(1)

    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     ListNode h1 = headA;
    //     ListNode h2 = headB;

    //     while (h2.next != null) {
    //         h2 = h2.next;
    //     }

    //     h2.next = h1;

    //     ListNode slow = headB;
    //     ListNode fast = headB;

    //     while (fast.next != null && fast.next.next != null) {
    //         slow = slow.next;
    //         fast = fast.next.next;

    //         if (slow == fast) {
    //             break;
    //         }
    //     }

    //     if (fast.next == null) {
    //         h2.next = null;
    //         return null;
    //     }

    //     fast = headB;
    //     while (slow != fast) {
    //         slow = slow.next;
    //         fast = fast.next;
    //     }

    //     h2.next = null;

    //     return slow;
    // }

    // Optimal Approach

    public static int sizeOfLL(ListNode head){
        int count = 0;

        ListNode temp = head;

        while(temp != null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode h1 = headA;
        ListNode h2 = headB;

        int sizeA = sizeOfLL(h1);
        int sizeB = sizeOfLL(h2);

        int diff = Math.abs(sizeA - sizeB);

        if(sizeA > sizeB){
            for(int i=0; i<diff; i++){
                h1 = h1.next;
            }
        }else{
            for(int i=0; i<diff; i++){
                h2 = h2.next;
            }
        }

        while(h1 != null && h2 != null){
            if(h1 == h2){
                return h1;
            }

            h1 = h1.next;
            h2 = h2.next;
        }

        return null;
    }
}