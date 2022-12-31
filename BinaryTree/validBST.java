package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import BinaryTree.levelOrder.TreeNode;

public class validBST {
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
        public boolean isValidBST(TreeNode root) {
            ArrayList<Integer> in = new ArrayList<>();
            Set<Integer> set = new HashSet<>();
            inOrder(root, in);
            boolean flag1 = true;
            ArrayList<Integer> clone = (ArrayList) in.clone();
            Collections.sort(clone);
            boolean flag2 = clone.equals(in);
            for (int n : in) {
                if (set.contains(n)) {
                    flag1 = false;
                    break;
                } else {
                    set.add(n);
                }
            }
            return flag1 && flag2;
        }

        public static void inOrder(TreeNode curNode, ArrayList<Integer> in) {
            if (curNode.left != null) {
                inOrder(curNode.left, in);
            }
            in.add(curNode.val);
            if (curNode.right != null) {
                inOrder(curNode.right, in);
            }
            return;
        }
    }
}
