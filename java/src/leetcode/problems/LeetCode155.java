package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/1 22:22
 */
public class LeetCode155 {

    class MinStack {

        Stack<Integer> stack;
        Stack<Integer> minStack;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            if (stack.empty()) {
                stack.push(val);
                minStack.push(val);
                return;
            }
            if (val > minStack.peek()) {
                minStack.push(minStack.peek());
            } else {
                minStack.push(val);
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.empty()) {
                return;
            }
            stack.pop();
            minStack.pop();
        }

        public int top() {
            if (stack.empty()) {
                return -1;
            }
            return stack.peek();
        }

        public int getMin() {
            if (minStack.empty()) {
                return -1;
            }
            return minStack.peek();
        }
    }

}
