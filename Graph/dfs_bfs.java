package Graph;

import java.util.ArrayList;
import java.util.HashSet;

public class dfs_bfs {
    public static void main(String[] args) {
        int[][] adj_list = { { 1, 3 }, { 0 }, { 3, 8 }, { 0, 4, 5, 2 }, { 3, 6 }, { 3 }, { 4, 7 }, { 6 }, { 2 } };
        HashSet<Integer> set = new HashSet<>();
        bfs(adj_list);
        System.out.println();
        dfs(adj_list, 0, set);
    }

    public static void bfs(int[][] graph) {
        ArrayList<Integer> q = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        q.add(0);
        set.add(0);
        while (q.size() > 0) {
            int node = q.remove(0);
            System.out.print(node + " ");
            set.add(node);
            for (int i = 0; i < graph[node].length; i++) {
                if (!set.contains(graph[node][i])) {
                    q.add(graph[node][i]);
                }
            }
        }
    }

    public static void dfs(int[][] graph, int curNode, HashSet<Integer> set) {
        System.out.print(curNode + " ");
        set.add(curNode);
        int[] con = graph[curNode];
        for (int i = 0; i < con.length; i++) {
            if (!set.contains(con[i])) {
                dfs(graph, con[i], set);
            }
        }
        return;

    }
}
