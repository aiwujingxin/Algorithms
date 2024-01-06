package leetcode.lists.interview;


import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/5 21:15
 */
public class Inter0305 {

    class SortedStack {

        Stack<Integer> sortedStack;
        Stack<Integer> tmpStack;

        public SortedStack() {
            sortedStack = new Stack<>();
            tmpStack = new Stack<>();
        }

        public void push(int val) {
            while (!sortedStack.isEmpty() && sortedStack.peek() < val) {
                tmpStack.add(sortedStack.pop());
            }
            while (!tmpStack.isEmpty() && tmpStack.peek() > val) {
                sortedStack.add(tmpStack.pop());
            }
            sortedStack.add(val);
        }

        public void pop() {
            while (!tmpStack.isEmpty()) {
                sortedStack.add(tmpStack.pop());
            }
            if (!sortedStack.isEmpty()) {
                sortedStack.pop();
            }
        }

        public int peek() {
            while (!tmpStack.isEmpty()) {
                sortedStack.add(tmpStack.pop());
            }
            if (!sortedStack.isEmpty()) {
                return sortedStack.peek();
            }
            return -1;
        }

        public boolean isEmpty() {
            return sortedStack.isEmpty();
        }
    }
}
