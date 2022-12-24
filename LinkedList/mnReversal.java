package LinkedList;

public class mnReversal {
    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.display();

        list.mnreverse(2, 4);

        list.display();
    }
}

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class Linkedlist {
    Node head;

    public void insert(int val) {
        Node node = new Node(val);

        if (this.head == null) {
            this.head = node;
        } else {
            Node curNode = this.head;
            while (curNode.next != null) {
                curNode = curNode.next;
            }
            curNode.next = node;
        }
    }

    public void display() {
        Node curNode = this.head;

        while (curNode != null) {
            if (curNode.next == null) {
                System.out.print(curNode.val);
            } else {
                System.out.print(curNode.val + "->");
            }
            curNode = curNode.next;
        }
        System.out.println();
    }

    public void mnreverse(int left, int right) {
        if (left == right) {
            return;
        }
        // Time:O(n)
        // Space:O(1)
        Node l, r;
        Node x, y;
        x = this.head;
        y = null;
        l = this.head;
        r = this.head;
        for (int i = 1; i < left; i++) {
            if (i == left - 1) {
                x = l;
            }
            l = l.next;
        }
        for (int i = 1; i < right; i++) {
            r = r.next;
        }
        y = r.next;

        if (left == 1) {
            this.head = r;
        } else {
            x.next = r;
        }

        Node prevNode = l;
        Node curNode = l.next;
        while (curNode != r) {
            Node next = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = next;
        }
        curNode.next = prevNode;
        l.next = y;

    }
}
