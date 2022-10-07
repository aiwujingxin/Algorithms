package leetcode.topinterview;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/26 00:19
 */
public class LeetCode155 {

    class MinStack {

        int min;
        Stack<Integer> stack;

        //copy
        public MinStack() {
            min = Integer.MAX_VALUE;
            stack = new Stack<>();
        }

        public void push(int val) {

            if (val <= min) {
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
