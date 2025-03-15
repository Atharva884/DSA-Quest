// TC: O(N*logN), SC: O(N)
class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(left.size() == right.size()){
            // Odd one, add to left
            right.add(num);
            left.add(right.poll());
        }else{
            // Even one, add to right
            left.add(num);
            right.add(left.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            // Even elements are there
            return ((left.peek() + right.peek()) / 2.0);
        }else{
            // Odd elements are there
            return left.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */