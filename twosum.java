import java.util.function.Function;

// Verify Constraints: Only positive , exactly one solution , solution may not
// exist

// Test cases: [] , [5] , [11] , [1,3,7,9,2] where target is 11

// Best case test case:[1,3,7,9,2],11 -> [3,4]
// [1,3,7,9,2],25 -> null
// [],target -> null
// [any],target -> null
// [1,5],6 -> [0,1]

// Figure out a solution without code:

public class twosum {
    static int[] ts(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            int val = target - arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == val) {
                    int[] res = { i, j };
                    return res;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 7, 9, 2 };
        int target = 6;
        int[] res = ts(arr, target);
        if (res != null) {
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]);
                System.out.print(" ");
            }
        } else {
            System.out.println("Value not found");
        }
    }
}
