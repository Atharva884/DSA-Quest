class Solution {
    public List<String[]> generateEdges(List<List<String>> accounts, int n){
        List<String[]> edges = new ArrayList<>();

        for(int i=0; i<n; i++){
            List<String> acc = accounts.get(i);

            if(acc.size() <= 2){
                continue;
            }

            for(int j=1; j<acc.size() - 1; j++){
                edges.add(new String[]{ acc.get(j), acc.get(j+1) });
            }
        }

        return edges;
    }

    public void union(int x, int y, int[] par, int[] rank){
        int px = find(x, par);
        int py = find(y, par);

        if(px == py){
            return;
        }

        if(rank[px] > rank[py]){
            par[py] = px;
        }else if(rank[px] < rank[py]){
            par[px] = py;
        }else{
            par[px] = py;
            rank[py]++;
        }
    }

    public int find(int x, int[] par){
        if(par[x] == x){
            return x;
        }

        int temp = find(par[x], par);
        par[x] = temp;

        return temp;
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();

        List<List<String>> ans = new ArrayList<>();


        // We need to form edges
        List<String[]> edges = generateEdges(accounts, n);

        // To remove duplicates
        HashSet<String> hs = new HashSet<>();
        for(int i=0; i<n; i++){
            List<String> acc = accounts.get(i);
            for(int j=1; j<acc.size(); j++){
                hs.add(acc.get(j));
            }
        }        

        int len = hs.size();
        int[] par = new int[len];
        int[] rank = new int[len];

        for(int i=0; i<len; i++){
            par[i] = i;
            rank[i] = 1;
        }

        // Do mapping
        HashMap<String, Integer> map = new HashMap<>(); 
        int k = 0;
        for(String str: hs){
            map.put(str, k);
            k++;
        }

        // Traverse the edges
        for(int i=0; i<edges.size(); i++){
            int u = map.get(edges.get(i)[0]);
            int v = map.get(edges.get(i)[1]);

            union(u, v, par, rank);
        }

        HashMap<Integer, List<String>> groups = new HashMap<>();
        
        for (String email : hs) {
            int index = map.get(email);
            int root = find(index, par);

            groups.putIfAbsent(root, new ArrayList<>());
            groups.get(root).add(email);
        }

        HashMap<Integer, String> nameMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = accounts.get(i).get(0);
            String email = accounts.get(i).get(1);

            int root = find(map.get(email), par); 

            // We are using putIfAbsent bcoz, u just don't need to override the value
            nameMap.putIfAbsent(root, name);  
        }

        for (int root : groups.keySet()) {
            List<String> emails = groups.get(root);
            String name = nameMap.get(root);

            // Sorting in lexicographically order
            Collections.sort(emails);

            List<String> merged = new ArrayList<>();
            merged.add(name);
            merged.addAll(emails);
            ans.add(merged);
        }

        return ans;
    }
}