package twoArray;

public class setMatrixZero {
    class Solution {
        public void setZeroes(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == 0) {
                        setZeroUp(matrix, i, j);
                        setZeroRight(matrix, i, j);
                        setZeroDown(matrix, i, j);
                        setZeroLeft(matrix, i, j);
                    }
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == -1000) {
                        matrix[i][j] = 0;
                    }
                }
            }
            return;
        }

        public static void setZeroUp(int[][] arr, int row, int col) {
            if (row < 0) {
                return;
            }
            if (arr[row][col] != 0) {
                arr[row][col] = -1000;
            }
            setZeroUp(arr, row - 1, col);
            return;
        }

        public static void setZeroDown(int[][] arr, int row, int col) {
            if (row >= arr.length) {
                return;
            }
            if (arr[row][col] != 0) {
                arr[row][col] = -1000;
            }
            setZeroDown(arr, row + 1, col);
            return;
        }

        public static void setZeroRight(int[][] arr, int row, int col) {
            if (col >= arr[0].length) {
                return;
            }
            if (arr[row][col] != 0) {
                arr[row][col] = -1000;
            }
            setZeroRight(arr, row, col + 1);
            return;
        }

        public static void setZeroLeft(int[][] arr, int row, int col) {
            if (col < 0) {
                return;
            }
            if (arr[row][col] != 0) {
                arr[row][col] = -1000;
            }
            setZeroLeft(arr, row, col - 1);
            return;
        }

    }
}
