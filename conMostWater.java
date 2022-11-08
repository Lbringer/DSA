
//Best case testcase:[7,1,2,3,9] => 7*4 = 28
//[] => 0
//[5] =>0
//[6,9,3,4,5,8] =>32 (8*4)

public class conMostWater {
    static int brute(int[] arr) {
        int maxArea = 0;
        for (int a = 0; a < arr.length; a++) {
            for (int b = a + 1; b < arr.length; b++) {
                int area = Math.min(arr[a], arr[b]) * (b - a);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    static int op(int[] arr) {
        int maxArea = 0;
        if (arr.length == 0) {
            return 0;
        }
        int a = 0;
        int b = arr.length - 1;
        while (a < b) {
            int area = Math.min(arr[a], arr[b]) * (b - a);
            if (area > maxArea) {
                maxArea = area;
            }
            if (arr[a] <= arr[b]) {
                a = a + 1;
            } else {
                b = b - 1;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 8, 1, 2, 3, 9 };
        System.out.println(brute(arr));
        System.out.println(op(arr));
    }
}

// brute space and time:
// O(1) and O(n^2)
// op space and time:
// O(1) and O(n)
