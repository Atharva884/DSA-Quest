import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] arr = graph[i];
            Arrays.fill(arr, 100001);
            graph[i][i] = 0;
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u][v] = w;
            graph[v][u] = w;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j],
                            graph[i][k] + graph[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int minIdx = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= min) {
                min = count;
                minIdx = Math.max(i, minIdx);
            }

        }

        return minIdx;
    }
}