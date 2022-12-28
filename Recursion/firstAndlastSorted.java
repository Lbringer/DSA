package Recursion;

public class firstAndlastSorted {
    // O(n)
    class Solution1 {
        public int[] searchRange(int[] nums, int target) {
            int index = search(target, nums, 0, nums.length - 1);

            System.out.println(index);

            if (index == -1) {
                int[] res = { -1, -1 };
                return res;
            } else {
                int l = index;
                int r = index;
                while (l - 1 >= 0 && nums[l - 1] == nums[index]) {
                    l--;
                }
                while (r + 1 < nums.length && nums[r + 1] == nums[index]) {
                    r++;
                }
                int[] res = { l, r };
                return res;
            }

        }

        public static int search(int val, int[] arr, int left, int right) {
            while (left <= right) {
                int mid = (int) (left + right) / 2;
                if (arr[mid] == val) {
                    return mid;
                } else if (arr[mid] > val) {
                    return search(val, arr, left, mid - 1);
                } else {
                    return search(val, arr, mid + 1, right);
                }
            }
            return -1;
        }
    }

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int index = search(target, nums, 0, nums.length - 1);

            if (index == -1) {
                int[] res = { -1, -1 };

                return res;
            } else {

                int l = findleft(target, nums, 0, index - 1, index);
                int r = findright(target, nums, index + 1, nums.length - 1, index);

                int[] res = { l, r };

                return res;
            }

        }

        public static int findleft(int val, int[] arr, int left, int right, int l) {
            while (left <= right) {
                int index = search(val, arr, left, right);

                if (index == -1) {
                    return l;
                } else {
                    l = index;

                    return findleft(val, arr, left, index - 1, l);
                }
            }
            return l;
        }

        public static int findright(int val, int[] arr, int left, int right, int r) {
            while (left <= right) {
                int index = search(val, arr, left, right);
                System.out.println(index);

                if (index == -1) {
                    return r;
                } else {
                    r = index;

                    return findright(val, arr, index + 1, right, r);
                }
            }
            return r;
        }

        public static int search(int val, int[] arr, int left, int right) {
            while (left <= right) {
                int mid = (int) (left + right) / 2;

                if (arr[mid] == val) {
                    return mid;
                } else if (arr[mid] > val) {
                    return search(val, arr, left, mid - 1);
                } else {
                    return search(val, arr, mid + 1, right);
                }
            }
            return -1;
        }
    }
}
