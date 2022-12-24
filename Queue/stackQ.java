package Queue;

import java.util.Stack;

public class stackQ {
    class MyQueue {
        Stack<Integer> stMain;
        Stack<Integer> st;

        public MyQueue() {
            stMain = new Stack<>();
            st = new Stack<>();
        }

        public void push(int x) {
            stMain.push(x);
        }

        public int pop() {
            int res = -1;
            while (!stMain.empty()) {
                res = stMain.pop();
                if (!stMain.empty()) {
                    st.push(res);
                }
            }
            while (!st.empty()) {
                stMain.push(st.pop());
            }
            return res;
        }

        public int peek() {
            int res = -1;
            while (!stMain.empty()) {
                res = stMain.pop();
                st.push(res);
            }
            while (!st.empty()) {
                stMain.push(st.pop());
            }
            return res;
        }

        public boolean empty() {
            return stMain.empty();
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
}
