import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static long brute(ArrayList<Integer> nums, int n, int k){
        long sum = 0;

        for(int i=0; i <= n-k; i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for(int j=i; j<i+k; j++){
                int num = nums.get(j);
                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            sum += (max + min);
        }

        return sum;
    }

    public static long optimal(ArrayList<Integer> nums, int n, int k){
        ArrayDeque<Integer> maxDq = new ArrayDeque<>();
        ArrayDeque<Integer> minDq = new ArrayDeque<>();
        long sum = 0;

        for(int i=0; i<k; i++){
            int num = nums.get(i);
            while(!maxDq.isEmpty() && num > maxDq.getLast()){
                maxDq.removeLast();
            }
            maxDq.addLast(num);

            while(!minDq.isEmpty() && num < minDq.getLast()){
                minDq.removeLast();
            }
            minDq.addLast(num);
        }

        sum += maxDq.getFirst() + minDq.getFirst();

        int sp = 0;
        int ep = k;

        while(ep < n){
            // Acquire the new elements
            int next = nums.get(ep);
            int old = nums.get(sp);

            while(!maxDq.isEmpty() && next > maxDq.getLast()){
                maxDq.removeLast();
            }
            maxDq.addLast(next);

            while(!minDq.isEmpty() && next < minDq.getLast()){
                minDq.removeLast();
            }
            minDq.addLast(next);

            // Release the old elements
            if(old == minDq.getFirst()) minDq.removeFirst();
            if(old == maxDq.getFirst()) maxDq.removeFirst();

            sum += maxDq.getFirst() + minDq.getFirst();

            sp++;
            ep++;
        }

        return sum;
    }

    public static long sumOfMaxAndMin(ArrayList<Integer> nums, int n, int k) {
        // Brute Approach
        // TC: O(N*K), SC: O(1)
        // return brute(nums, n, k);

        return optimal(nums, n, k);
    }
}
