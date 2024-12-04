//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{
    static int maxSize;
    static int size;
    static int min;
    static int max;
    
    public static int getSize(Node root){
        if(root == null){
            return 0;
        }
        
        int l = getSize(root.left);
        int r = getSize(root.right);
        
        return l + r + 1;
    }
    
    public static boolean isBST(Node root, int min, int max){
        if(root == null){
            return true;
        }

        if(root.data < min || root.data > max){
            return false;
        }

        boolean l = isBST(root.left, min, root.data - 1);
        boolean r = isBST(root.right, root.data + 1, max);

        if(l == false || r == false){
            return false;
        }

        return true;
    }
    
    public static void solve(Node root, int min, int max){
        if(root == null){
            return;
        }
        
        solve(root.left, min, max);
        solve(root.right, min, max);
        
        if(isBST(root, min, max)){
            // if it's BST how to calculate the size
            int sze = getSize(root);
            maxSize = Math.max(maxSize, sze);
        }
    }
    
    static int largestBst(Node root){
        min = Integer.MIN_VALUE;
        max = Integer.MAX_VALUE;
        size = 0;
        maxSize = 0;
        
        solve(root, min, max);
        
        return maxSize;
    }
    
}