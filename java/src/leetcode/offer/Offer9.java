package leetcode.offer;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 13:38
 */
public class Offer9 {

    class CQueue {

        Stack<Integer> stack1;
        Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            if (!stack2.empty()) {
                return stack2.pop();
            }
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.add(stack1.pop());
                }
            }

            if (!stack2.empty()) {
                return stack2.pop();
            } else {
                return -1;
            }
        }
    }
}
