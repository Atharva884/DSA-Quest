class Node{
    int ch;
    // HashMap<Integer, Node> map;
    Node[] temp;
    
    public Node(int _ch){
        this.ch = _ch;
        this.temp = new Node[2];
    }
}

class Solution {
    public static int[] prefixXOR(int[] arr, int n){
        int[] pfXor = new int[n];
        pfXor[0] = arr[0];
        
        for(int i=1; i<n; i++){
            pfXor[i] = pfXor[i-1] ^ arr[i];
        }
        
        return pfXor;
    }
    
    // TC: O(1), SC: O(1)
    public static int checkBit(int num, int i){
        if((num & (1 << i)) != 0) return 1;
        
        return 0;
    }
    
    // TC: O(N), SC: O(1)
    public static int max(int[] arr){
        int ans = Integer.MIN_VALUE;
        for(int num: arr){
            ans = Math.max(ans, num);
        }
        return ans;
    }
    
    // TC: O(32) ~ O(1), SC: O(1)
    public static int getMSB(int num){
        int bit = -1;
        
        for(int i=31; i>=0; i--){
            if(checkBit(num, i) == 1){
                bit = i;
                break;
            }
        }
        
        return bit;
    }
    
    // TC: O(P), SC: O(2)
    public static void insert(int num, int p, Node root){
        Node t = root;
        
        for(int i=p; i>=0; i--){
            int ch = checkBit(num, i);
            
            if(t.temp[ch] != null){
                t = t.temp[ch];
            }else{
                Node newNode = new Node(ch);
                t.temp[ch] = newNode;
                t = t.temp[ch];
            }
        }
    }
    
    // TC: O(P), SC: O(1)
    public static int search(int num, int p, Node root){
        Node t = root;
        int b = 0;
        
        for(int i=p; i>=0; i--){
            int ch = checkBit(num, i);
            int myBit = 1 - ch;
            
            if(t.temp[myBit] != null){
                // If there is optimal bit, use it
                b += ((1 << i) * myBit);
                t = t.temp[myBit];
            }else{
                // If no optimal bit, then choose this bit
                b += ((1 << i) * ch);
                t = t.temp[ch];
            }
        }
        
        return b;
    }

   
    public static int findMaximumXOR(int[] arr) {
        int n = arr.length;
        
        int num = max(arr);
        int maxBit = getMSB(num);
        int res = 0;
        
        Node root = new Node(-1);
        
        // Insert all the bits of the number
        insert(0, maxBit, root);
        for(int i=0; i<n; i++){
            insert(arr[i], maxBit, root);
        }
        
        // Search
        for(int i=0; i<n; i++){
            int a = arr[i];
            int b = search(a, maxBit, root);
            
            res = Math.max(res, a ^ b);
        }
        
        return res;
    }
    
    // Optimal Approach
    // TC: O(N * 32), SC: O(N * 32)
    public static int maxSubarrayXOR(int N, int arr[]) {
        int[] pfXor = prefixXOR(arr, N);
        
        return findMaximumXOR(pfXor);
    }
}
