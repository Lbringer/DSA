package String;

class validPalinDrome {

    public static String preProcess(String s) {
        String p = "";
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                p = p + s.charAt(i);
            }
        }

        return p;
    }

    // Two pointers at end

    public static boolean isValid1(String s) {
        // Space:O(n)
        // Time:O(n)
        s = preProcess(s);

        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    // Two pointers at middle

    public static boolean isValid2(String s) {
        s = preProcess(s);
        int i, j;
        i = j = Math.round(s.length() / 2);
        if (s.length() % 2 == 0) {
            i--;
        }
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    // Reverse String and compare
    public static boolean isValid3(String s) {
        s = preProcess(s);
        String p = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            p = p + s.charAt(i);
        }
        return s.equals(p);
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isValid1(s));
        System.out.println(isValid2(s));
        System.out.println(isValid3(s));
    }
}
