class Tuple implements Comparable<Tuple> {
    int passengers;
    int start;
    int end;

    public Tuple(int _passengers, int _start, int _end) {
        this.passengers = _passengers;
        this.start = _start;
        this.end = _end;
    }

    public int compareTo(Tuple o) {
        if (this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}

class Pair implements Comparable<Pair> {
    int passengers;
    int end;

    public Pair(int _passengers, int _end) {
        this.passengers = _passengers;
        this.end = _end;
    }

    public int compareTo(Pair o) {
        return this.end - o.end;
    }
}

class Solution {
    // TC: O(NlogN), SC: O(N)
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        Tuple[] arr = new Tuple[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Tuple(trips[i][0], trips[i][1], trips[i][2]);
        }

        Arrays.sort(arr);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int count = 0;

        for (Tuple t : arr) {
            while (!pq.isEmpty() && pq.peek().end <= t.start) {
                count -= pq.poll().passengers;
            }

            pq.add(new Pair(t.passengers, t.end));
            count += t.passengers;

            if (count > capacity) {
                return false;
            }
        }

        return true;
    }
}
