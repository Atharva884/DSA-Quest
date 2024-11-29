/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int sizeOfLL(ListNode temp) {
        int size = 0;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public ListNode reverse(ListNode temp) {
        ListNode head = temp;

        ListNode p = temp;
        ListNode r = null;

        while (p != null) {
            ListNode q = p.next;
            p.next = r;
            r = p;
            p = q;
        }

        head = r;

        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int size1 = sizeOfLL(temp1);
        int size2 = sizeOfLL(temp2);

        int diff = Math.abs(size1 - size2);
        Stack<Integer> st = new Stack<>();

        if (size1 < size2) {
            int i = 0;
            while (i < diff) {
                st.push(temp2.val);
                st.push(0);
                temp2 = temp2.next;
                i++;
            }
        } else {
            int i = 0;
            while (i < diff) {
                st.push(temp1.val);
                st.push(0);
                temp1 = temp1.next;
                i++;
            }
        }

        ListNode t1 = temp1;
        ListNode t2 = temp2;

        while (t1 != null && t2 != null) {
            st.push(t1.val);
            st.push(t2.val);

            t1 = t1.next;
            t2 = t2.next;
        }

        ListNode tmp = new ListNode();
        ListNode dummy = tmp;

        int carry = 0;

        while (st.size() >= 2) {
            int sum = st.pop() + st.pop() + carry;
            carry = sum / 10;

            ListNode newNode = new ListNode(sum % 10); 
            tmp.next = newNode;
            tmp = tmp.next;
        }

        while (!st.isEmpty()) {
            int sum = st.pop() + carry; 
            carry = sum / 10; 

            ListNode newNode = new ListNode(sum % 10); 
            tmp.next = newNode;
            tmp = tmp.next;
        }

        if (carry > 0) { 
            ListNode newNode = new ListNode(carry);
            tmp.next = newNode;
        }

        return reverse(dummy.next);
    }
}

