package BinaryTree;

import BinaryTree.levelOrder.TreeNode;

public class numNodes {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int countNodes(TreeNode root) {
            int res = 0;
            if (root == null) {
                return 0;
            }
            int height = getHeight(root);
            // System.out.println(height);
            if (height == 0) {
                return 1;
            }
            int upperCount = (int) Math.pow(2.0, (double) height - 1) - 1;
            // System.out.println(upperCount);
            res = res + upperCount;
            int left = 0;
            int right = upperCount;
            while (left < right) {
                int idx = (int) (Math.ceil((left + right) / 2.0));
                System.out.println(left + " " + right);
                System.out.println((left + right) / 2.0);
                if (isValid(idx, root, height)) {
                    left = idx;
                } else {
                    right = idx - 1;
                }
            }
            res = res + left + 1;
            return res;
        }

        public static int getHeight(TreeNode root) {
            int count = 0;
            TreeNode temp = root;
            while (temp != null) {
                count = count + 1;
                temp = temp.left;
            }
            return count;
        }

        public static boolean isValid(int index, TreeNode root, int height) {
            TreeNode temp = root;
            int level = 1;
            int left = 0;
            int right = (int) Math.pow(2.0, (double) height - 1) - 1;
            // System.out.println(right);
            while (level < height) {
                // System.out.println(level);
                if (temp == null) {
                    return false;
                }
                int mid = (int) (Math.ceil((left + right) / 2.0));
                // System.out.println(left+" "+right);
                if (mid > index) {
                    temp = temp.left;
                    right = mid - 1;
                } else {
                    temp = temp.right;
                    left = mid;
                }
                level++;
            }
            if (temp == null) {
                return false;
            } else {
                return true;
            }
        }
    }
}
