package Recursion;

public class quickSort {

    public static int par(int[] arr, int start, int end) {
        int pivot = end;
        int i = start;
        while (i <= pivot) {
            if (arr[i] > arr[pivot]) {
                if (pivot - 1 == i) {
                    int temp = arr[pivot];
                    arr[pivot] = arr[i];
                    arr[i] = temp;
                    pivot--;
                } else {
                    int temp = arr[pivot];
                    arr[pivot] = arr[pivot - 1];
                    arr[pivot - 1] = temp;

                    temp = arr[pivot];
                    arr[pivot] = arr[i];
                    arr[i] = temp;

                    pivot--;
                    i--;
                }
            }
            i++;
        }

        return pivot;
    }

    public static void quick(int[] arr, int start, int end) {
        if (start < end) {
            int pi = par(arr, start, end);

            quick(arr, start, pi - 1);
            quick(arr, pi + 1, end);

        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 1, 6, 4, 2 };
        quick(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
    }
}