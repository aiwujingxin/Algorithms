package classic;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2021-12-05 3:07 下午
 */
public class Number0304 {


    Stack<Integer> stack1;
    Stack<Integer> stack2;

    /**
     * Initialize your data structure here.
     */
    public Number0304() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {

        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        return -1;

    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        if (!stack2.isEmpty()) {
            return stack2.peek();
        }

        return -1;
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() || stack2.isEmpty();
    }

}
