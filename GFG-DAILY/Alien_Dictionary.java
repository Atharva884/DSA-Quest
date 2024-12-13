// User function Template for Java

// class Solution {
//     public ArrayList<ArrayList<Integer>> construction(String[] dict, int[] inDegree,  int n){
//         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
//         for(int i=0; i<n; i++){
//             graph.add(new ArrayList<>());
//         }
        
//         for(int i = 0; i < n - 1; i++) { 
//             String str1 = dict[i];
//             String str2 = dict[i + 1];
            
//             int min = Math.min(str1.length(), str2.length());
            
//             for(int j=0; j<min; j++){
//                 if(str1.charAt(j) != str2.charAt(j)){
//                     int u = str1.charAt(j) - 'a';
//                     int v = str2.charAt(j) - 'a';
                    
//                     graph.get(u).add(v);
//                     inDegree[v]++; 
//                     break;
//                 }
//             }
        
//         }
        
        
//         return graph;
//     }
    
//     public String findOrder(String[] dict, int k) {
//         int n = dict.length;
        
//         // HashMap<Character, Integer> map = new HashMap<>();
//         // HashMap<Integer, Character> revMap = new HashMap<>();
        
//         int len = k;
        
//         int[] inDegree = new int[len];

//         // for(int i = 0; i < len; i++) {
//         //     char ch = (char) (97 + i);
//         //     map.put(ch, i);
//         //     revMap.put(i, ch);
//         // }
        
//         ArrayList<ArrayList<Integer>> graph = construction(dict, inDegree, len);
    
        
//         // Perform Topo sort
//         Queue<Integer> q = new LinkedList<>();
        
//         for(int i=0; i<len; i++){
//             if(inDegree[i] == 0){
//                 q.add(i);
//             }
//         }

//         List<Integer> temp = new ArrayList<>();
        
//         while(!q.isEmpty()){
//             int vtx = q.poll();
            
//             temp.add(vtx);
            
//             for(int nbr: graph.get(vtx)){
//                 inDegree[nbr]--;
                
//                 if(inDegree[nbr] == 0){
//                     q.add(nbr);
//                 }
//             }
//         }
        
//         // If there are still nodes left with non-zero in-degree, there is a cycle
//         if(temp.size() != len) {
//             return "";  // Return an empty string if there's a cycle
//         }

//         // Construct the result string
//         StringBuilder ans = new StringBuilder();
//         for(int i=0; i<temp.size(); i++){
//             ans.append((char) (temp.get(i) + 'a'));
//         }
       
//         return ans.toString();
//     }
// }

class Solution {
    // Graph construction function
    public ArrayList<ArrayList<Integer>> construction(String[] dict, int[] inDegree, int k) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph based on dictionary comparison
        for (int i = 0; i < dict.length - 1; i++) {
            String str1 = dict[i];
            String str2 = dict[i + 1];

            int minLen = Math.min(str1.length(), str2.length());

            // Find the first character where they differ
            for (int j = 0; j < minLen; j++) {
                if (str1.charAt(j) != str2.charAt(j)) {
                    int u = str1.charAt(j) - 'a';
                    int v = str2.charAt(j) - 'a';

                    // If an edge is not already present, add it
                    if (!graph.get(u).contains(v)) {
                        graph.get(u).add(v);
                        inDegree[v]++;
                    }
                    break;
                }
            }
        }
        return graph;
    }

    public String findOrder(String[] dict, int k) {
        int[] inDegree = new int[k];  // Array to store the in-degree of each node
        Arrays.fill(inDegree, 0);     // Initialize all in-degrees to 0

        ArrayList<ArrayList<Integer>> graph = construction(dict, inDegree, k);

        // Perform topological sort using a priority queue for lexicographical order
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all vertices with 0 in-degree
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            int u = pq.poll();
            result.append((char) (u + 'a')); // Add character to result

            // Decrease in-degree for all neighbors
            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    pq.add(v); // Add to priority queue if its in-degree is now 0
                }
            }
        }

        // If the result length is less than k, there was a cycle (invalid input)
        if (result.length() < k) {
            return "";
        }

        return result.toString();
    }
}