package twoArray;

public class landWater {
    class Solution {
        public int numIslands(char[][] grid) {
            int row = grid.length;
            int col = grid[0].length;

            int count = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (grid[i][j] == '1') {
                        count++;
                        zeroDFS(grid, i, j);
                    }
                }
            }

            return count;
        }

        public static void zeroDFS(char[][] grid, int row, int col) {
            if (grid[row][col] == '0') {
                return;
            }
            grid[row][col] = '0';
            if (row - 1 >= 0) {
                zeroDFS(grid, row - 1, col);
            }
            if (col + 1 < grid[0].length) {
                zeroDFS(grid, row, col + 1);
            }
            if (row + 1 < grid.length) {
                zeroDFS(grid, row + 1, col);
            }
            if (col - 1 >= 0) {
                zeroDFS(grid, row, col - 1);
            }
            return;

        }
    }
}
