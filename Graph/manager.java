package Graph;

import java.util.ArrayList;

public class manager {
    class Solution {
        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> empty = new ArrayList<>();
                list.add(empty);
            }
            makeAdj(headID, manager, list);
            int time = 0;
            time = findTime(list, informTime, headID);
            return time;
        }

        public static int findTime(ArrayList<ArrayList<Integer>> graph, int[] time, int curNode) {
            ArrayList<Integer> con = graph.get(curNode);
            int maxFound = 0;
            for (int i = 0; i < con.size(); i++) {
                maxFound = Math.max(findTime(graph, time, con.get(i)), maxFound);
            }
            return maxFound + time[curNode];
        }

        public static void makeAdj(int curNode, int[] man, ArrayList<ArrayList<Integer>> list) {
            for (int i = 0; i < man.length; i++) {
                if (man[i] == -1) {
                    continue;
                }
                ArrayList<Integer> con = list.get(man[i]);
                con.add(i);
            }
            return;
        }

    }
}
