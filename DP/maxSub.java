package DP;

public class maxSub {
    // Top Down
    class Solution1 {
        public int maxSubArray(int[] nums) {
            int[][] dp = new int[nums.length][nums.length];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    dp[i][j] = (int) Double.POSITIVE_INFINITY;
                }
            }
            return findMax(nums, 0, nums.length - 1, dp);
        }

        public static int findMax(int[] nums, int s, int e, int[][] dp) {
            if (dp[s][e] != (int) Double.POSITIVE_INFINITY) {
                return dp[s][e];
            }
            if (s == e) {
                return nums[s];
            }
            int sum = 0;
            for (int i = s; i <= e; i++) {
                sum += nums[i];
            }
            int child = Math.max(findMax(nums, s + 1, e, dp), findMax(nums, s, e - 1, dp));
            int res = Math.max(sum, child);
            dp[s][e] = res;
            return res;

        }
    }
}
