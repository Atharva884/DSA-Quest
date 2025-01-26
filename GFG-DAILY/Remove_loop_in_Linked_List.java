/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    // Brute Force Approach
    // TC: O(N), SC: O(N)
    
    // public static void removeLoop(Node head) {
    //     HashSet<Node> hs = new HashSet<>();
        
    //     Node temp = head;
        
    //     while(temp != null){
    //         if(hs.contains(temp.next)){
    //             temp.next = null;
    //         }
            
    //         hs.add(temp);
    //         temp = temp.next;
    //     }
    // }
    
    // Optimal Approach
    // TC: O(N), SC: O(1)
    
    public static void removeLoop(Node head) {
        Node s = head;
        Node f = head;
        
        boolean isLoop = false;
        
        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
            
            if(s == f){
                isLoop = true;
                break;
            }
        }
        
        if(isLoop == false) return;
        
        s = head;
        
        if(s == f){
            while(f.next != s){
                f = f.next;
            }
            
            f.next = null;
            return;
        }
        

        while(s.next != f.next){
            s = s.next;
            f = f.next;
        }
        
        f.next = null;
    }
}