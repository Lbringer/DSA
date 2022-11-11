package String;

import java.util.ArrayList;
import java.util.Stack;

//"ab##"->" "

// "ab" and "ab"->true
//"ab#z" and "az#z"->true
//"abc#d" and "acc#c"->false
//"x#y#z#" and "a#"->True
//"Ab#z" and "az#z"->true
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
        return true;
    }

    public static void main(String[] args) {
        String s1 = "ab##";
        String s2 = "c#d#";

        System.out.println(brute(s1, s2));
        System.out.println(op(s1, s2));
    }
}

// brute time and space complexity
// O(a+b) and O(a+b)
