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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode temp = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;

        while(temp != null){
            if(temp.next != null && temp.val == temp.next.val){
                // Adjacent values are same
                while(temp.next != null && temp.val == temp.next.val){
                    temp = temp.next;
                }

                prev.next = temp.next;
            }else{
                prev = prev.next;
            }
            
            temp = temp.next;
        }

        return dummy.next;
    }
}