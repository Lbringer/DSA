package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class coureScheduler {
    class Solution {
        public boolean canFinish(int num, int[][] pre) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            ArrayList<Integer> empty;
            for (int i = 0; i < num; i++) {
                empty = new ArrayList<>();
                graph.add(empty);
            }
            makeGraph(pre, graph);
            int[] top = new int[num];
            for (int i = 0; i < num; i++) {
                top[i] = 0;
            }
            for (int i = 0; i < graph.size(); i++) {
                ArrayList<Integer> con = graph.get(i);
                for (int j = 0; j < con.size(); j++) {
                    top[con.get(j)]++;
                }
            }
            while (check(top) != -1) {
                int index = check(top);
                top[index] = -1;
                ArrayList<Integer> con = graph.get(index);
                for (int i = 0; i < con.size(); i++) {
                    top[con.get(i)]--;
                }
            }
            return checkFinal(top);
        }

        public static boolean checkFinal(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != -1) {
                    return false;
                }
            }
            return true;
        }

        public static int check(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    return i;
                }
            }
            return -1;
        }

        public static void makeGraph(int[][] pre, ArrayList<ArrayList<Integer>> graph) {
            for (int i = 0; i < pre.length; i++) {
                int[] edge = pre[i];
                int nodeStart = edge[1];
                int nodeEnd = edge[0];
                ArrayList<Integer> con = graph.get(nodeStart);
                con.add(nodeEnd);
            }
        }
    }

    class Solution1 {
        public boolean canFinish(int num, int[][] pre) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            ArrayList<Integer> empty;
            for (int i = 0; i < num; i++) {
                empty = new ArrayList<>();
                graph.add(empty);
            }
            makeGraph(pre, graph);
            for (int i = 0; i < graph.size(); i++) {
                HashSet<Integer> set = new HashSet<>();
                ArrayList<Integer> q = new ArrayList<>();
                ArrayList<Integer> con = graph.get(i);
                for (int j = 0; j < con.size(); j++) {
                    q.add(con.get(j));
                }
                while (q.size() > 0) {
                    int curNode = q.remove(0);
                    set.add(curNode);
                    if (curNode == i) {
                        return false;
                    }
                    con = graph.get(curNode);
                    for (int j = 0; j < con.size(); j++) {
                        if (set.contains(con.get(j))) {
                            continue;
                        }
                        q.add(con.get(j));
                    }
                }
            }
            return true;
        }

        public static void makeGraph(int[][] pre, ArrayList<ArrayList<Integer>> graph) {
            for (int i = 0; i < pre.length; i++) {
                int[] edge = pre[i];
                int nodeStart = edge[1];
                int nodeEnd = edge[0];
                ArrayList<Integer> con = graph.get(nodeStart);
                con.add(nodeEnd);
            }
        }
    }
}
