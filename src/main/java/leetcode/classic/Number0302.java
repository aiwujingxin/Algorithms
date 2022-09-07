package leetcode.classic;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2021-12-05 3:02 下午
 */
public class Number0302 {


    Stack<Integer> stack;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public Number0302() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // 入栈
        stack.push(x);
        // 如果最小栈为空，x存入最小栈中
        // 如果x <= 当前栈中最小值，x存入栈中
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
