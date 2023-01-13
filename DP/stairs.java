package DP;

import java.util.HashMap;

public class stairs {
    // Bottom Up
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int[] minCost = new int[cost.length];
            for (int i = 0; i < minCost.length; i++) {
                if (i == 0 || i == 1) {
                    minCost[i] = cost[i];
                } else {
                    minCost[i] = cost[i] + Math.min(minCost[i - 1], minCost[i - 2]);
                }
            }
            int res = cost.length;
            return Math.min(minCost[res - 1], minCost[res - 2]);
        }
    }

    // Top Down
    class Solution1 {
        public int minCostClimbingStairs(int[] cost) {
            HashMap<Integer, Integer> sol = new HashMap<>();
            sol.put(0, cost[0]);
            sol.put(1, cost[1]);
            return minCost(cost, cost.length, sol);
        }

        public static int minCost(int[] cost, int index, HashMap<Integer, Integer> sol) {
            if (sol.containsKey(index)) {
                return sol.get(index);
            }
            if (index < 0) {
                return 0;
            }
            int val = Math.min(minCost(cost, index - 1, sol), minCost(cost, index - 2, sol));
            if (index == cost.length) {
                sol.put(index, val);
                return val;
            }
            val = val + cost[index];
            sol.put(index, val);
            return val;
        }
    }
}
