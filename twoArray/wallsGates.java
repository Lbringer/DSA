package twoArray;

import java.util.ArrayList;

public class wallsGates {
    public static void main(String[] args) {
        int[][] arr = { { -2, -1, 0, -2 }, { -2, -2, -2, -1 }, { -2, -1, -2, -1 }, { 0, -1, -2, -2 } };
        int[][] res = wallsGatess(arr);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] wallsGatess(int[][] arr) {
        ArrayList<ArrayList<Integer>> q = new ArrayList<>();
        ArrayList<Integer> toPush;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    toPush = new ArrayList<>();
                    toPush.add(i);
                    toPush.add(j);
                    q.add(toPush);
                }
            }
        }
        int levelTracker = q.size();
        int val = 0;
        while (q.size() > 0) {
            if (levelTracker == 0) {
                val++;
                levelTracker = q.size();
            }
            ArrayList<Integer> pop = q.remove(0);
            int row = pop.get(0);
            int col = pop.get(1);
            levelTracker--;
            if (arr[row][col] < 0) {
                arr[row][col] = val;
            } else {
                arr[row][col] = Math.min(arr[row][col], val);
            }
            // System.out.println(row + " " + col + " " + val);
            if (row - 1 >= 0 && arr[row - 1][col] == -2) {
                toPush = new ArrayList<>();
                toPush.add(row - 1);
                toPush.add(col);
                q.add(toPush);
            }
            if (col + 1 < arr[0].length && arr[row][col + 1] == -2) {
                toPush = new ArrayList<>();
                toPush.add(row);
                toPush.add(col + 1);
                q.add(toPush);
            }
            if (row + 1 < arr.length && arr[row + 1][col] == -2) {
                toPush = new ArrayList<>();
                toPush.add(row + 1);
                toPush.add(col);
                q.add(toPush);
            }
            if (col - 1 >= 0 && arr[row][col - 1] == -2) {
                toPush = new ArrayList<>();
                toPush.add(row);
                toPush.add(col - 1);
                q.add(toPush);
            }
        }
        return arr;
    }
}
