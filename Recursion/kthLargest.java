package Recursion;

public class kthLargest {
    // Brute:
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            quick(nums, 0, nums.length - 1);
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    System.out.print(nums[i]);
                } else {
                    System.out.print(nums[i] + ",");
                }
            }
            return nums[nums.length - k];
        }

        public static void quick(int[] arr, int start, int end) {
            if (start < end) {
                int pivot = end;
                int i, j;
                i = j = start;

                while (j <= pivot) {
                    if (arr[j] < arr[pivot]) {
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                        i++;
                    }
                    j++;
                }

                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;

                quick(arr, start, i - 1);
                quick(arr, i + 1, end);
            }
        }
    }

    // Optimized (Hoares Algo)
    class Solution2 {
        public int findKthLargest(int[] nums, int k) {
            int idtf = nums.length - k;

            select(nums, idtf, 0, nums.length - 1);

            return nums[idtf];
        }

        public static void select(int[] arr, int index, int start, int end) {
            if (start < end) {
                int pivot = end;
                int i, j;
                i = j = start;

                while (j <= pivot) {
                    if (arr[j] < arr[pivot]) {
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                        i++;
                    }
                    j++;
                }
                int temp = arr[i];
                arr[i] = arr[pivot];
                arr[pivot] = temp;

                if (i > index) {
                    select(arr, index, start, i - 1);
                } else if (i < index) {
                    select(arr, index, i + 1, end);
                } else {
                    return;
                }
            }
        }
    }

}
