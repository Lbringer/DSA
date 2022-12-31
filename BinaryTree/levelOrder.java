package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class levelOrder {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            List<TreeNode> q = new ArrayList<>();
            List<Integer> t = new ArrayList<>();
            if (root == null) {
                return res;
            }
            int num = 1;
            q.add(root);

            while (q.size() != 0) {
                int n = num;
                num = 0;
                for (int i = 0; i < n; i++) {
                    TreeNode temp = q.remove(0);
                    t.add(temp.val);
                    if (temp.left != null) {
                        num++;
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        num++;
                        q.add(temp.right);
                    }
                }
                res.add(t);
                t = new ArrayList<>();
            }

            return res;
        }
    }
}
