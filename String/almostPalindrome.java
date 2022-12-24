package String;

public class almostPalindrome {

    public static String pre(String s) {
        s = s.toLowerCase();
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                res = res + s.charAt(i);
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static boolean isValid(String s) {
        // space:O(1)
        // time:O(n)
        s = pre(s);
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                int i1 = i + 1;
                int j1 = j - 1;
                return isPalindrome(s, i1, j) || isPalindrome(s, i, j1);
            }
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "cbbcc";
        System.out.println(isValid(s));
    }
}
