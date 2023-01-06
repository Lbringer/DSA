package twoArray;

import java.util.ArrayList;

public class oranges {
    class Solution {
        public int orangesRotting(int[][] grid) {
            int row = grid.length;
            int col = grid[0].length;
            System.out.println(row + " " + col);
            boolean[][] bol = new boolean[row][col];
            ArrayList<ArrayList<Integer>> indexRot = new ArrayList<>();
            ArrayList<Integer> index;
            int minCount = 0;
            int freshCount = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    bol[i][j] = false;
                    if (grid[i][j] == 1) {
                        freshCount++;
                    }
                    if (grid[i][j] == 2) {
                        index = new ArrayList<>();
                        index.add(i);
                        index.add(j);
                        indexRot.add(index);
                    }
                }
            }
            if (freshCount == 0) {
                return 0;
            }
            ArrayList<ArrayList<Integer>> q = new ArrayList<>();
            ArrayList<Integer> toPush;
            while (indexRot.size() != 0) {
                toPush = indexRot.remove(0);
                int r = toPush.get(0);
                int c = toPush.get(1);
                bol[r][c] = true;
                q.add(toPush);
            }
            // Delimiter
            toPush = new ArrayList<>();
            toPush.add(-1);
            toPush.add(-1);
            q.add(toPush);
            System.out.println(q + " " + freshCount);
            // for(int k=0;k<row;k++){
            // for(int l=0;)
            // }
            // BFS
            while (q.size() != 1) {
                System.out.println(q + " " + minCount);
                ArrayList<Integer> pop = q.remove(0);
                int r = pop.get(0);
                int c = pop.get(1);
                if (r == -1 && c == -1) {
                    toPush = new ArrayList<>();
                    toPush.add(-1);
                    toPush.add(-1);
                    q.add(toPush);
                    minCount++;
                    continue;
                }
                System.out.println(r + " " + c);
                if (r - 1 >= 0 && grid[r - 1][c] == 1 && bol[r - 1][c] == false) {
                    toPush = new ArrayList<>();
                    toPush.add(r - 1);
                    toPush.add(c);
                    q.add(toPush);
                    bol[r - 1][c] = true;
                    freshCount--;
                }
                if (c + 1 < col && grid[r][c + 1] == 1 && bol[r][c + 1] == false) {
                    toPush = new ArrayList<>();
                    toPush.add(r);
                    toPush.add(c + 1);
                    q.add(toPush);
                    bol[r][c + 1] = true;
                    freshCount--;
                    // System.out.println(bol[1][1]);
                }
                if (r + 1 < row && grid[r + 1][c] == 1 && bol[r + 1][c] == false) {
                    toPush = new ArrayList<>();
                    toPush.add(r + 1);
                    toPush.add(c);
                    q.add(toPush);
                    bol[r + 1][c] = true;
                    freshCount--;
                }
                if (c - 1 >= 0 && grid[r][c - 1] == 1 && bol[r][c - 1] == false) {
                    toPush = new ArrayList<>();
                    toPush.add(r);
                    toPush.add(c - 1);
                    q.add(toPush);
                    bol[r][c - 1] = true;
                    freshCount--;
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(bol[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(freshCount);
            if (freshCount > 0) {
                return -1;
            }
            return minCount;
        }
    }
}
