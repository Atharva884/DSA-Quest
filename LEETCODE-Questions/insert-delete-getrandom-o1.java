class RandomizedSet {
    HashMap<Integer, Integer> map;
    List<Integer> arr;
    Random r;

    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, arr.size());
        arr.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int remIdx = map.get(val);
        int lastIdx = arr.size() - 1;
        int lastElem = arr.get(lastIdx);

        // If the element which we need to remove is the last element in the arr
        if (remIdx != lastIdx) {
            arr.set(remIdx, lastElem);
            map.put(lastElem, remIdx);
        }

        arr.remove(lastIdx);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int idx = r.nextInt(arr.size());
        return arr.get(idx);
    }
}
