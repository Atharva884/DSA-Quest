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

class Pair{
    int size;
    int max;
    int min;
    
    public Pair(int _size, int _max, int _min){
        this.size = _size;
        this.max = _max;
        this.min = _min;
    }
}

class Solution{
    // Brute Force Approach
    // TC: O(N^2), SC: O(H)
    
    // static int maxSize;
    // static int size;
    // static int min;
    // static int max;
    
    // public static int getSize(Node root){
    //     if(root == null){
    //         return 0;
    //     }
        
    //     int l = getSize(root.left);
    //     int r = getSize(root.right);
        
    //     return l + r + 1;
    // }
    
    // public static boolean isBST(Node root, int min, int max){
    //     if(root == null){
    //         return true;
    //     }

    //     if(root.data < min || root.data > max){
    //         return false;
    //     }

    //     boolean l = isBST(root.left, min, root.data - 1);
    //     boolean r = isBST(root.right, root.data + 1, max);

    //     if(l == false || r == false){
    //         return false;
    //     }

    //     return true;
    // }
    
    // public static void solve(Node root, int min, int max){
    //     if(root == null){
    //         return;
    //     }
        
    //     solve(root.left, min, max);
    //     solve(root.right, min, max);
        
    //     if(isBST(root, min, max)){
    //         // if it's BST how to calculate the size
    //         int sze = getSize(root);
    //         maxSize = Math.max(maxSize, sze);
    //     }
    // }
    
    // static int largestBst(Node root){
    //     min = Integer.MIN_VALUE;
    //     max = Integer.MAX_VALUE;
    //     size = 0;
    //     maxSize = 0;
        
    //     solve(root, min, max);
        
    //     return maxSize;
    // }
    
    
    // Optimal Approach
    // TC: O(N), SC: O(H)
    
    public static Pair largestBSTHelper(Node root){
        if(root == null){
            return new Pair(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }   
        
        Pair left = largestBSTHelper(root.left);
        Pair right = largestBSTHelper(root.right);
        
        // If it's a BST
        if(root.data > left.max && root.data < right.min){
            return new Pair(left.size + right.size + 1, Math.max(root.data, right.max), Math.min(root.data, left.min));
        }
        
        // It's not a BST
        return new Pair(Math.max(left.size, right.size), Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    static int largestBst(Node root){
        return largestBSTHelper(root).size;
    }
}