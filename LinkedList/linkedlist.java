package LinkedList;

public class linkedlist {

    Node head;

    public static linkedlist insert(linkedlist list, int data) {
        Node new_node = new Node(data);

        if (list.head == null) {
            list.head = new_node;
        } else {
            Node last = list.head;

            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;

        }
        return list;
    }

    public static void display(linkedlist list) {
        Node it = list.head;
        while (it != null) {
            if (it.next == null) {
                System.out.println(it.val);
            } else {
                System.out.print(it.val + "->");
            }
            it = it.next;
        }
        System.out.println();
    }

    public static linkedlist reverse(linkedlist list) {

        Node prevNode = list.head;
        Node curNode = list.head.next;

        list.head.next = null;

        while (curNode != null) {
            if (curNode.next == null) {
                list.head = curNode;
            }
            Node temp = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = temp;
        }
        return list;

    }

    public static void main(String[] args) {
        linkedlist list = new linkedlist();

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);

        display(list);

    }
}

class Node {
    int val;
    Node next;

    Node(int v) {
        val = v;
        next = null;
    }
}
