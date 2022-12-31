package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class rightView {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // BFS solution O(n),O(n)
    class Solution1 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            List<TreeNode> q = new ArrayList<>();
            q.add(root);
            int nodes = 1;

            while (q.size() != 0) {
                int n = nodes;
                nodes = 0;
                for (int i = 1; i <= n; i++) {
                    TreeNode temp = q.remove(0);
                    if (temp != null) {
                        if (i == n) {
                            res.add(temp.val);
                        }
                        if (temp.left != null) {
                            q.add(temp.left);
                            nodes++;
                        }
                        if (temp.right != null) {
                            q.add(temp.right);
                            nodes++;
                        }
                    }
                }
            }
            return res;
        }
    }

    // DFS
    class Solution2 {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            rightView(root, res, 1, 0);

            return res;
        }

        public static int rightView(TreeNode curNode, List<Integer> res, int curLevel, int maxLevel) {
            if (curNode != null) {
                if (curLevel > maxLevel) {
                    res.add(curNode.val);
                    maxLevel = Math.max(maxLevel, curLevel);
                }
                if (curNode.right != null) {
                    maxLevel = rightView(curNode.right, res, curLevel + 1, maxLevel);
                }
                if (curNode.left != null) {
                    maxLevel = rightView(curNode.left, res, curLevel + 1, maxLevel);
                }
            }
            return maxLevel;
        }
    }
}
