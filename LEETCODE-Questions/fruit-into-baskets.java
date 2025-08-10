class Solution {
    public int brute(int[] fruits){
        int n = fruits.length;
        int max = 0;

        for(int sp=0; sp<n; sp++){
            HashSet<Integer> hs = new HashSet<>();
            for(int ep=sp; ep<n; ep++){
                int fruit = fruits[ep];
                hs.add(fruit);

                if(hs.size() <= 2){
                    max = Math.max(max, ep - sp + 1);
                }else{
                    break;
                }
            }
        }

        return max;
    }

    public int better(int[] fruits){
        int n = fruits.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        int sp = 0;
        int ep = 0;
        int max = 0;

        while(ep < n){
            // Acquire the new fruit in the basket
            int next = fruits[ep];
            map.put(next, map.getOrDefault(next, 0) + 1);

            while(map.size() > 2){
                // Release the fruits from the basket
                int fruit = fruits[sp];
                map.put(fruit, map.get(fruit) - 1);
                if(map.get(fruit) == 0) map.remove(fruit);
                
                sp++;
            }
               
            max = Math.max(max, ep - sp + 1);
            ep++;
        }
        
        return max;
    }

    public int optimal(int[] fruits){
        int n = fruits.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        int sp = 0;
        int ep = 0;
        int max = 0;

        while(ep < n){
            // Acquire the new fruit in the basket
            int next = fruits[ep];
            map.put(next, map.getOrDefault(next, 0) + 1);

            if(map.size() > 2){
                // Release the fruits from the basket
                int fruit = fruits[sp];
                map.put(fruit, map.get(fruit) - 1);
                if(map.get(fruit) == 0) map.remove(fruit);
                
                sp++;
            }
               
            max = Math.max(max, ep - sp + 1);
            ep++;
        }
        
        return max;
    }

    public int totalFruit(int[] fruits) {
        // Brute Approach
        // TC: O(N^2), SC: O(1)
        // return brute(fruits);

        // Better Approach
        // TC: O(N+N) ~ O(2N), SC: O(1)
        // return better(fruits);

        // Optimal Approach
        // TC: O(N), SC: O(1)
        return optimal(fruits);
    }
}
