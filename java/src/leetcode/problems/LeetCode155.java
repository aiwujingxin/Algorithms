package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/1 22:22
 */
public class LeetCode155 {

    class MinStack {
        Stack<Integer> s = new Stack<>(), min = new Stack<>();

        public void push(int x) {
            s.push(x);
            min.push(min.isEmpty() ? x : Math.min(x, min.peek()));
        }

        public void pop() {
            s.pop();
            min.pop();
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }
}
