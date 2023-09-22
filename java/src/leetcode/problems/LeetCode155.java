package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 21:28
 */
public class LeetCode155 {

    class MinStack {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public MinStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int val) {
            stack1.push(val);
            if (!stack2.empty() && val > stack2.peek()) {
                stack2.push(stack2.peek());
            } else {
                stack2.push(val);
            }
        }

        public void pop() {
            if (stack1.empty()) {
                return;
            }
            stack1.pop();
            stack2.pop();
        }

        public int top() {

            if (stack1.empty()) {
                return -1;
            }
            return stack1.peek();
        }

        public int getMin() {
            if (stack2.empty()) {
                return -1;
            }
            return stack2.peek();
        }
    }

}
