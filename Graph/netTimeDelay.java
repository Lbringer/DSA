package Graph;

public class netTimeDelay {
    class Solution {
        public int networkDelayTime(int[][] times, int n, int k) {
            k = k - 1;
            int inf = (int) Double.POSITIVE_INFINITY;
            // Bellman
            int[] dis = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == k) {
                    dis[i] = 0;
                } else {
                    dis[i] = inf;
                }
            }
            for (int i = 0; i < n; i++) {
                boolean flag = false;
                for (int j = 0; j < times.length; j++) {
                    int[] edge = times[j];
                    int start = edge[0] - 1;
                    int end = edge[1] - 1;
                    int w = edge[2];
                    int node = dis[start];
                    if (node == inf) {
                        continue;
                    }
                    int val = node + w;
                    if (val < dis[end]) {
                        dis[end] = val;
                        flag = true;
                    }
                }
                for (int l = 0; l < dis.length; l++) {
                    System.out.print(dis[l] + " ");
                }
                System.out.println();
                if (flag && i == n) {
                    return -1;
                }
                if (!flag) {
                    break;
                }
            }
            int max = max(dis);
            if (max == inf) {
                return -1;
            } else {
                return max;
            }
        }

        public static int max(int[] dis) {
            int max = 0;
            for (int i = 0; i < dis.length; i++) {
                if (dis[max] < dis[i]) {
                    max = i;
                }
            }
            return dis[max];
        }
    }

    class Solution1 {
        public int networkDelayTime(int[][] times, int n, int k) {
            k = k - 1;
            int inf = (int) Double.POSITIVE_INFINITY;
            // Djikstra
            // Distance array
            int[] dis = new int[n];
            boolean[] bol = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (i == k) {
                    dis[i] = 0;
                } else {
                    dis[i] = inf;
                }
                bol[i] = false;
            }
            // Adj matrix
            int[][] graph = makeGraph(times, n);
            for (int i = 0; i < n; i++) {
                int indexMin = min(dis, bol);
                // System.out.println(indexMin);
                // printArray(dis);
                printArray(bol);
                distance(dis, graph, indexMin);
            }
            int maxVal = max(dis);
            if (maxVal == inf) {
                return -1;
            } else {
                return maxVal;
            }
        }

        public static int max(int[] dis) {
            int max = 0;
            for (int i = 0; i < dis.length; i++) {
                if (dis[max] < dis[i]) {
                    max = i;
                }
            }
            return dis[max];
        }

        public static void distance(int[] dis, int[][] graph, int indexMin) {
            int[] con = graph[indexMin];
            for (int i = 0; i < con.length; i++) {
                if (con[i] != -1) {
                    int edge = con[i];
                    int node = dis[indexMin];
                    int val = edge + node;
                    dis[i] = Math.min(dis[i], val);
                }
            }
        }

        public static int min(int[] dis, boolean[] bol) {
            int min = 0;
            for (int i = 0; i < dis.length; i++) {
                if (bol[i] == false) {
                    min = i;
                    break;
                }
            }
            for (int i = 0; i < dis.length; i++) {
                if (bol[i] == false) {
                    if (dis[min] > dis[i]) {
                        min = i;
                    }
                }
            }
            System.out.println(min);
            bol[min] = true;
            return min;
        }

        public static int[][] makeGraph(int[][] times, int n) {
            int[][] res = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res[i][j] = -1;
                }
            }
            for (int i = 0; i < times.length; i++) {
                int start = times[i][0] - 1;
                int end = times[i][1] - 1;
                int w = times[i][2];
                res[start][end] = w;
            }
            return res;
        }

        public static void printArray(boolean[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
