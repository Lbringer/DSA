package Stack;

import java.util.Stack;

public class validP {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> st = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                // Left braces in stack
                if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                    st.push(s.charAt(i));
                } else {
                    if (st.empty()) {
                        return false;
                    }
                    char cl = st.pop();
                    char cr = s.charAt(i);
                    if (cl == '{' && (cr == ']' || cr == ')')) {
                        return false;
                    }
                    if (cl == '[' && (cr == '}' || cr == ')')) {
                        return false;
                    }
                    if (cl == '(' && (cr == ']' || cr == '}')) {
                        return false;
                    }
                }
            }
            if (!st.empty()) {
                return false;
            }
            return true;
        }
    }
}
