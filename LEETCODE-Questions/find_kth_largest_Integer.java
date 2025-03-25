import java.math.BigInteger;

class Solution {
    // TC: O(NlogN), SC: O(K)
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();

        for (String num : nums) {
            BigInteger no = new BigInteger(num);
            pq.add(no);

            if (pq.size() > k) {
                pq.poll(); 
            }
        }

        return pq.peek().toString();
    }
}
