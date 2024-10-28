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

    // TC: O(N) + O(N/2), SC: O(1)

    // public static int sizeOfLL(ListNode head){
    //     ListNode temp = head;
    //     int count = 0;

    //     while(temp != null){
    //         count++;
    //         temp = temp.next;
    //     }

    //     return count;
    // }

    // public static ListNode middleNode(ListNode head) {
    //     int size = sizeOfLL(head); 
    //     ListNode temp = head;

    //     int avg = size / 2;

    //     int i = 0;
    //     while(temp != null && i < avg){
    //         temp = temp.next;
    //         i++;
    //     }   

    //     return temp;
    // }

    // Way - 1
    // public static ListNode middleNode(ListNode head){
    //     ListNode temp = head;

    //     ListNode slow = head;
    //     ListNode fast = head;

    //     while(fast != null && fast.next != null){
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }

    //     return slow;
    // }

    // Way - 2
    // Needed for splitting the linked list in middle
    // We can't actually split the linked list efficiently with way 1
    public static ListNode middleNode(ListNode head){
        ListNode temp = head;

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // If fast is not reached null, then we are processing the odd ll
        if(fast.next != null){
            return slow.next;
        }

        return slow;
    }
}