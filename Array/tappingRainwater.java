package Array;

public class tappingRainwater {
    // Test case:[0,1,0,2,1,0,3,1,0,1,2] => 8
    // []=>0
    // [3,4,3]=>0
    static int brute(int[] arr) {
        int total = 0;
        for (int a = 0; a < arr.length; a++) {
            int maxL = 0;
            int maxR = 0;
            for (int b = a; b >= 0; b--) {
                if (arr[b] > maxL) {
                    maxL = arr[b];
                }
            }
            for (int c = a; c < arr.length; c++) {
                if (arr[c] > maxR) {
                    maxR = arr[c];
                }
            }
            int cw = Math.min(maxL, maxR) - arr[a];
            if (cw > 0) {
                total = total + cw;
            }
        }
        return total;
    }

    static int op(int[] arr) {
        int total = 0;
        int a = 0;
        int b = arr.length - 1;
        int maxL = 0;
        int maxR = 0;
        while (a < b) {
            if (arr[a] <= arr[b]) {
                if (arr[a] > maxL) {
                    maxL = arr[a];
                } else {
                    int cw = maxL - arr[a];
                    total = total + cw;
                }
                a = a + 1;
            } else {
                if (arr[b] > maxR) {
                    maxR = arr[b];
                } else {
                    int cw = maxR - arr[b];
                    total = total + cw;
                }
                b = b - 1;
            }

        }
        return total;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2 };
        System.out.println(brute(arr));
        System.out.println(op(arr));
    }
}
// Brute space and time complexity:
// O(1) and O(n^2)
// OP space and time complexity:
// O(1) and O(n)