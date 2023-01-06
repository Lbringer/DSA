package twoArray;

public class searchTarget {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int row = matrix.length;
            int col = matrix[0].length;
            int rowT = row - 1;
            for (int i = 0; i < row; i++) {
                if (matrix[i][0] <= target) {
                    rowT = i;
                }
            }
            for (int j = 0; j < col; j++) {
                if (matrix[rowT][j] == target) {
                    return true;
                }
            }
            return false;
        }
    }
}
