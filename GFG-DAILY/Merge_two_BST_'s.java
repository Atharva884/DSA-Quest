// User function Template for Java

/*
class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

*/
class Solution {
    public static void inOrder(Node root, List<Integer> arr){
        if(root == null){
            return;
        }
        
        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }
    
    public static List<Integer> mergeTwoSortedArr(List<Integer> arr1, List<Integer> arr2){
        List<Integer> ans = new ArrayList<>();
        int n = arr1.size();
        int m = arr2.size();
        
        int i=0;
        int j=0;
        
        while(i < n && j < m){
            if(arr1.get(i) <= arr2.get(j)){
                ans.add(arr1.get(i));
                i++;
            }else if(arr1.get(i) >= arr2.get(j)){
                ans.add(arr2.get(j));
                j++;
            }
        }
        
        // arr1 is left
        while(i < n){
            ans.add(arr1.get(i));
            i++;
        }
        
        // arr2 is left
        while(j < m){
            ans.add(arr2.get(j));
            j++;
        }
        
        return ans;
    }
    
    public List<Integer> merge(Node root1, Node root2) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        
        inOrder(root1, arr1);
        inOrder(root2, arr2);
        
        
        return mergeTwoSortedArr(arr1, arr2);
    }
}
