package LinkedList;

public class flattenmultiDoubly {
    // LeetCode coded solution
    // Space:O(1)
    // Time:O(n^2)
    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    class Solution {
        public Node flatten(Node head) {
            Node curNode = head;
            while (curNode != null) {
                if (curNode.child != null) {
                    Node next = curNode.next;
                    Node it = curNode.child;
                    curNode.next = it;
                    it.prev = curNode;
                    while (it.next != null) {
                        it = it.next;
                    }
                    it.next = next;
                    if (next != null) {
                        next.prev = it;
                    }
                    curNode.child = null;
                }
                curNode = curNode.next;
            }
            Node temp = head;
            while (temp != null) {
                if (temp.next == null) {
                    System.out.print(temp.val);
                } else {
                    System.out.print(temp.val + "->");
                }
                temp = temp.next;
            }
            return head;
        }
    }
}
