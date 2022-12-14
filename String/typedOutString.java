package String;

import java.util.Stack;

//"ab##"->" "

// "ab" and "ab"->true
//"ab#z" and "az#z"->true
//"abc#d" and "acc#c"->false
//"x#y#z#" and "a#"->True
//"Ab#z" and "az#z"->false
public class typedOutString {

    public static Stack<Character> typed(String S) {
        Stack<Character> res = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (res.size() > 0) {
                    res.pop();
                }
            } else {
                res.push(S.charAt(i));
            }
        }
        return res;
    }

    public static boolean brute(String s, String t) {
        Stack<Character> s1 = typed(s);
        Stack<Character> s2 = typed(t);
        return s1.equals(s2);

    }

    public static boolean op(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        int hash1 = 0;
        int hash2 = 0;
        while (i >= 0 || j >= 0) {
            char a = s.charAt(i);
            char b = t.charAt(j);
            if (a == '#' || b == '#') {
                if (a == '#') {
                    hash1 += 2;
                    while (hash1 > 0) {
                        i--;
                        hash1--;
                        System.out.println(i);
                        a = s.charAt(i);
                        if (a == '#') {
                            hash1 += 2;
                        }
                    }
                }
                if (b == '#') {
                    hash2 += 2;
                    while (hash2 > 0) {
                        j--;
                        hash2--;
                        b = t.charAt(j);
                        if (b == '#') {
                            hash2 += 2;
                        }
                    }
                }
            } else {
                if (a != b) {
                    return false;
                } else {
                    i--;
                    j--;
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s1 = "ab#c";
        String s2 = "ad#c";
        System.out.println(op(s1, s2));
    }
}

// brute time and space complexity
// O(a+b) and O(a+b)
