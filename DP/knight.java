package DP;

public class knight {
    // Bottom Up
    class Solution {
        public double knightProbability(int n, int k, int row, int column) {
            double[][][] dp = new double[k + 1][n][n];
            dp[0][row][column] = 1;
            int[][] dir = { { -2, 1 }, { -2, -1 }, { 1, 2 }, { -1, 2 }, { 2, -1 }, { 2, 1 }, { 1, -2 }, { -1, -2 } };

            for (int i = 1; i <= k; i++) {
                for (int l = 0; l < n; l++) {
                    for (int j = 0; j < n; j++) {
                        double val = 0;
                        for (int m = 0; m < dir.length; m++) {
                            int[] move = dir[m];
                            int r = l + move[0];
                            int c = j + move[1];
                            if (r < 0 || r >= n || c < 0 || c >= n) {
                                continue;
                            }
                            val = val + dp[i - 1][l + move[0]][j + move[1]];
                        }
                        dp[i][l][j] = val / 8.0;
                    }
                }
            }
            double res = 0;
            for (int l = 0; l < n; l++) {
                for (int j = 0; j < n; j++) {
                    res = res + dp[k][l][j];
                }
            }
            return res;

        }
    }

    // Top down
    class Solution1 {
        public double knightProbability(int n, int k, int row, int column) {
            int[][] dir = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { -1, -2 }, { 1, -2 } };
            return knight(dir, row, column, k, n);
        }

        public static double knight(int[][] dir, int r, int c, int k, int n) {
            double[][][] dp = new double[k + 1][n][n];
            return recurse(dir, r, c, k, n, dp);
        }

        public static double recurse(int[][] dir, int r, int c, int k, int n, double[][][] dp) {
            if (r < 0 || r >= n || c < 0 || c >= n) {
                return 0;
            }
            if (k == 0) {
                return 1;
            }
            if (dp[k][r][c] != 0.0) {
                return dp[k][r][c];
            }
            float res = 0;
            for (int i = 0; i < dir.length; i++) {
                int[] move = dir[i];
                res += recurse(dir, r + move[0], c + move[1], k - 1, n, dp);
            }
            dp[k][r][c] = res / 8.0;
            return res / 8.0;
        }
    }
}
