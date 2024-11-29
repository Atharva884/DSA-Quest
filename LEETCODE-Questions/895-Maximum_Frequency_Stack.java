class FreqStack {
    HashMap<Integer, Integer> freqMap;
    HashMap<Integer, Stack<Integer>> map;
    int maxFq;

    public FreqStack() {
        freqMap = new HashMap<>();
        map = new HashMap<>();
        maxFq = 0;
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0);
        freq++;
        freqMap.put(val, freq);

        if(map.containsKey(freq) == false){
            map.put(freq, new Stack<>());
            maxFq = Math.max(maxFq, freq);
        }

        map.get(freq).add(val);
    }
    
    public int pop() {
        int rem = map.get(maxFq).pop();
        int freq = freqMap.get(rem);
        freq--;
        freqMap.put(rem, freq);

        if(map.get(maxFq).size() == 0){
            map.remove(maxFq);
            maxFq--;
        }

        return rem;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */