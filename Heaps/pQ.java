package Heaps;

import java.util.ArrayList;

public class pQ {
    public static void main(String[] args) {
        Pri obj = new Pri(11);
        obj.push(2);
        obj.push(10);
        obj.push(12);
        obj.push(33);
        obj.push(14);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
    }
}

class Pri {
    ArrayList<Integer> heap;

    Pri(int a) {
        heap = new ArrayList<>();
        heap.add(a);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int peek() {
        return heap.get(0);
    }

    private int parent(int index) {
        return (int) Math.floor((double) (index - 1) / 2);
    }

    private int leftChild(int index) {
        return (index * 2) + 1;
    }

    private int rightChild(int index) {
        return (index * 2) + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void push(int val) {
        heap.add(val);
        int index = heap.size() - 1;
        int par = parent(index);

        while (par >= 0 && par < heap.size() && heap.get(par) < heap.get(index)) {
            swap(par, index);
            index = par;
            par = parent(index);
        }
    }

    public int pop() {
        // System.out.println(heap);
        swap(0, heap.size() - 1);
        // System.out.println(heap);
        int res = heap.remove(heap.size() - 1);
        // System.out.println(heap);
        int index = 0;
        int left = leftChild(0);
        // System.out.println(left);
        int right = rightChild(0);
        // System.out.println(right);
        int max = 0;
        while (true) {
            boolean flag = false;
            if (right >= 0 && right < heap.size()) {
                flag = true;
                max = right;
            }
            if (left >= 0 && right < heap.size()) {
                if (flag) {
                    if (heap.get(left) > heap.get(right)) {
                        max = left;
                    }
                } else {
                    max = left;
                }
            }
            // System.out.println(index + " " + max);
            if (index == max) {
                break;
            } else {
                if (heap.get(index) < heap.get(max)) {
                    swap(index, max);
                    index = max;
                    left = leftChild(index);
                    right = rightChild(index);
                } else {
                    break;
                }
            }
            // System.out.println(left);
            // System.out.println(right);
            // System.out.println(max);
            // System.out.println(index);
            // System.out.println(heap);
        }

        return res;
    }
}
