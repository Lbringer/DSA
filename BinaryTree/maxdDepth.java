package BinaryTree;

public class maxdDepth {
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

    class Solution {
        public int maxDepth(TreeNode root) {
            return count(root, 0);
        }

        public int count(TreeNode curNode, int count) {
            if (curNode == null) {
                return count;
            } else {
                count++;
                int left = count(curNode.left, count);
                int right = count(curNode.right, count);
                return Math.max(left, right);
            }
        }
    }
}
