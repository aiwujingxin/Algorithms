package leetcode.lists.offer;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 23:39
 */
public class Offer30 {

    class MinStack {


        Stack<Integer> stack;
        Stack<Integer> minstack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
            minstack = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (!minstack.empty()) {
                if (minstack.peek() < x) {
                    minstack.push(minstack.peek());
                } else {
                    minstack.push(x);
                }
            } else {
                minstack.push(x);
            }
        }

        public void pop() {
            if (stack.empty()) {
                return;
            }
            stack.pop();
            minstack.pop();
        }

        public int top() {
            if (stack.empty()) {
                return -1;
            }
            return stack.peek();
        }

        public int min() {
            if (minstack.empty()) {
                return -1;
            }
            return minstack.peek();
        }
    }
}
