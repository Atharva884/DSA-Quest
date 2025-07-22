class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> map;
    ArrayList<Integer> arr;
    Random r;

    public RandomizedCollection() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        r = new Random();
    }
    
    public boolean insert(int val) {
        boolean isTrue = false;
        if(!map.containsKey(val)){
            isTrue = true;
        }

        HashSet<Integer> hs = map.getOrDefault(val, new HashSet<>());
        hs.add(arr.size());
        map.put(val, hs);

        arr.add(val);

        return isTrue;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val) || map.get(val).isEmpty()) return false;

        HashSet<Integer> indices = map.get(val);
        int remIdx = indices.iterator().next(); // get any index of val
        indices.remove(remIdx);

        int lastIdx = arr.size() - 1;
        int lastVal = arr.get(lastIdx);

        // Move lastVal to remIdx if needed
        if (remIdx != lastIdx) {
            arr.set(remIdx, lastVal);

            // Update map for lastVal
            map.get(lastVal).remove(lastIdx);
            map.get(lastVal).add(remIdx);
        }

        arr.remove(lastIdx);

        // Clean up if val has no more indices
        if (indices.isEmpty()) {
            map.remove(val);
        }

        return true;
    }
    
    public int getRandom() {
        int idx = r.nextInt(arr.size());

        return arr.get(idx);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
