package DP;

public class houseRobber {

    // Top Down
    class Solution1 {
        public int rob(int[] nums) {
            int[] dp = new int[nums.length];
            if (nums.length == 1) {
                return nums[0];
            }
            return Math.max(maxMoney(nums.length - 1, nums, dp), maxMoney(nums.length - 2, nums, dp));
        }

        public static int maxMoney(int index, int[] nums, int[] dp) {
            if (index == 0 || index == 1) {
                return nums[index];
            }
            if (dp[index] != 0) {
                return dp[index];
            }
            int it = index - 2;
            int max = 0;
            while (it >= 0) {
                max = Math.max(maxMoney(it, nums, dp), max);
                it--;
            }
            dp[index] = nums[index] + max;
            return dp[index];
        }
    }
}
