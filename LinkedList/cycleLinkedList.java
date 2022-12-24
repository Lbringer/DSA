package LinkedList;

import java.util.HashSet;

public class cycleLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution1 {
        public ListNode detectCycle(ListNode head) {
            HashSet<ListNode> set = new HashSet<>();
            ListNode curNode = head;
            while (curNode != null) {
                if (set.contains(curNode)) {
                    return curNode;
                } else {

                    set.add(curNode);
                }
                curNode = curNode.next;
            }
            return null;
        }
    }

    // Hare and Tortoise
    public class Solution2 {
        public ListNode detectCycle(ListNode head) {
            ListNode t, h;
            t = h = head;
            if (h == null || h.next == null || h.next.next == null) {
                return null;
            }
            h = h.next.next;
            t = t.next;
            while (h != t) {
                if (h == null || h.next == null || h.next.next == null) {
                    return null;
                }
                h = h.next.next;
                t = t.next;
            }
            System.out.println(t.val);
            ListNode m = t;
            ListNode s = head;
            while (m != s) {
                m = m.next;
                s = s.next;
            }
            return m;
        }
    }
}
