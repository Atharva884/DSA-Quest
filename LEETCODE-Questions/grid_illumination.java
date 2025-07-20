class Solution {
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 }, { -1, -1 }, {0 , 0} };

    public boolean checkBounds(int x, int y, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n);
    }

    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        HashMap<Integer, Integer> m1 = new HashMap<>(); // row 
        HashMap<Integer, Integer> m2 = new HashMap<>(); // col
        HashMap<Integer, Integer> m3 = new HashMap<>(); // row - col (TL - BR)
        HashMap<Integer, Integer> m4 = new HashMap<>(); // row + col (TR - BL)
        HashMap<Integer, Integer> m5 = new HashMap<>(); // storing lamps

        for (int i = 0; i < lamps.length; i++) {
            int x = lamps[i][0];
            int y = lamps[i][1];

            m1.put(x, m1.getOrDefault(x, 0) + 1);
            m2.put(y, m2.getOrDefault(y, 0) + 1);
            m3.put(x - y, m3.getOrDefault(x - y, 0) + 1);
            m4.put(x + y, m4.getOrDefault(x + y, 0) + 1);
            m5.put(x * n + y, m5.getOrDefault(x * n + y, 0) + 1);
        }

        int len = queries.length;
        int[] ans = new int[len];

        int idx = 0;
        for (int[] query : queries) {
            int x = query[0];
            int y = query[1];

            if (m1.getOrDefault(x, 0) > 0 || m2.getOrDefault(y, 0) > 0 || m3.getOrDefault(x - y, 0) > 0
                    || m4.getOrDefault(x + y, 0) > 0) {
                ans[idx] = 1;
            }

            // We need to eliminate the 8 adjacent lamps
            for (int d = 0; d < 9; d++) {
                int newX = x + dirs[d][0];
                int newY = y + dirs[d][1];

                if(checkBounds(newX, newY, n) && m5.containsKey(newX * n + newY)) {
                    int times = m5.get(newX * n + newY);

                    m1.put(newX, m1.getOrDefault(newX, 0) - times);
                    m2.put(newY, m2.getOrDefault(newY, 0) - times);
                    m3.put(newX - newY, m3.getOrDefault(newX - newY, 0) - times);
                    m4.put(newX + newY, m4.getOrDefault(newX + newY, 0) - times);
                    m5.remove(newX * n + newY);
                }
            }

            idx++;
        }

        return ans;
    }

}
