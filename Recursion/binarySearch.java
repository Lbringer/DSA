package Recursion;

import java.util.Arrays;

public class binarySearch {

    public static int search(int val, int[] arr, int left, int right) {
        Arrays.sort(arr);
        int mid = (int) (left + right) / 2;
        while (left <= right) {
            if (arr[mid] == val) {
                return mid;
            } else if (arr[mid] > val) {
                return search(val, arr, left, mid - 1);
            } else if (arr[mid] < val) {
                return search(val, arr, mid + 1, right);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 3, 1, 6, 4, 2 };
        System.out.println(search(5, arr, 0, arr.length - 1));
    }
}
