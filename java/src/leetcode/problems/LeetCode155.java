package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/1 22:22
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
            if (stack2.isEmpty() || val < stack2.peek()) {
                stack1.push(val);
                stack2.push(val);
            } else {
                stack1.push(val);
                stack2.push(stack2.peek());
            }
        }

        public void pop() {
            if (stack1.isEmpty()) {
                return;
            }
            stack1.pop();
            stack2.pop();
        }

        public int top() {
            if (stack1.isEmpty()) {
                return -1;
            }
            return stack1.peek();
        }

        public int getMin() {
            if (stack2.isEmpty()) {
                return -1;
            }
            return stack2.peek();
        }
    }

}
