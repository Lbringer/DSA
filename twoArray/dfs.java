package twoArray;

import java.util.ArrayList;

public class dfs {
    public static void main(String[] args) {

        int[][] array = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 } };
        int maxRow = array.length - 1;
        int maxCol = array[0].length - 1;
        boolean[][] booleanArray = { { false, false, false, false, false }, { false, false, false, false, false },
                { false, false, false, false, false }, { false, false, false, false, false } };
        boolean[][] booleanArray2 = { { false, false, false, false, false }, { false, false, false, false, false },
                { false, false, false, false, false }, { false, false, false, false, false } };
        dfs_trav(array, booleanArray, 0, 0, maxRow, maxCol);
        bfs_trav(array, booleanArray2);

    }

    public static void dfs_trav(int[][] arr, boolean[][] booleanArray, int row, int col,
            int maxRow, int maxCol) {

        if (!booleanArray[row][col]) {
            System.out.print(arr[row][col] + " ");
            booleanArray[row][col] = true;
        } else {
            return;
        }
        if (row - 1 >= 0) {
            dfs_trav(arr, booleanArray, row - 1, col, maxRow, maxCol);
        }
        if (col + 1 <= maxCol) {
            dfs_trav(arr, booleanArray, row, col + 1, maxRow, maxCol);
        }
        if (row + 1 <= maxRow) {
            dfs_trav(arr, booleanArray, row + 1, col, maxRow, maxCol);
        }
        if (col - 1 >= 0) {
            dfs_trav(arr, booleanArray, row, col - 1, maxRow, maxCol);
        }
        return;
    }

    public static void bfs_trav(int[][] arr, boolean[][] booleanArray) {
        System.out.println();
        ArrayList<ArrayList<Integer>> q = new ArrayList<>();
        int row = 0;
        int col = 0;
        ArrayList<Integer> push = new ArrayList<>();
        push.add(row);
        push.add(col);
        q.add(push);
        while (q.size() != 0) {
            ArrayList<Integer> pop = q.remove(0);
            row = pop.get(0);
            col = pop.get(1);
            if (!booleanArray[row][col]) {
                System.out.print(arr[row][col] + " ");
                booleanArray[row][col] = true;
                if (row - 1 >= 0) {
                    push = new ArrayList<>();
                    push.add(row - 1);
                    push.add(col);
                    q.add(push);
                }
                if (col + 1 < arr[0].length) {
                    push = new ArrayList<>();
                    push.add(row);
                    push.add(col + 1);
                    q.add(push);
                }
                if (row + 1 < arr.length) {
                    push = new ArrayList<>();
                    push.add(row + 1);
                    push.add(col);
                    q.add(push);
                }
                if (col - 1 >= 0) {
                    push = new ArrayList<>();
                    push.add(row);
                    push.add(col - 1);
                    q.add(push);
                }
            }
        }
    }
}
