package Stack;

import java.util.Stack;

public class minRemoveP {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            Stack<Integer> st = new Stack<>();
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '(') {
                    st.push(i);
                } else if (sb.charAt(i) == ')') {
                    if (st.empty()) {
                        sb.deleteCharAt(i);
                        i--;
                    } else {
                        st.pop();
                    }
                }
            }
            while (!st.empty()) {
                sb.deleteCharAt(st.pop());
            }
            return sb.toString();
        }
    }
}
