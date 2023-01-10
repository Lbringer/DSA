package DP;

import java.util.HashMap;

public class stairs {
    class Solution {
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
