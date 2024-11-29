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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num: nums){
            hs.add(num);
        }

        ListNode temp = head;
        int comp = 0;

        while(temp != null){
            int ans = 0;
            while(temp != null && hs.contains(temp.val)){
                ans++;
                temp = temp.next;
            }

            if(ans != 0){
                ans = 0;
                comp++;
            }

            if(temp != null){
                temp = temp.next;
            }
        }

        return comp;
    }
}