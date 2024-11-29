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

class Pair{
    int idx;
    int val;

    public Pair(int _idx, int _val){
        this.idx = _idx;
        this.val = _val;
    }
}

class Solution {
    public static int sizeOfLL(ListNode temp){
        int size = 0;

        while(temp != null){
            size++;
            temp = temp.next;
        }

        return size;
    }

    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int n = sizeOfLL(temp);
        
        Stack<Pair> st = new Stack<>();

        int[] ans = new int[n];
        Arrays.fill(ans, 0);

        int i = 0;
        while(temp != null){
            while(!st.isEmpty() && temp.val > st.peek().val){
                Pair pair = st.pop();
                ans[pair.idx] = temp.val;        
            }

            if(temp != null){
                st.push(new Pair(i, temp.val));
                i++;
                temp = temp.next;
            }
        } 

        return ans;
    }
}