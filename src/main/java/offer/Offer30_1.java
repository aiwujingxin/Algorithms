package offer;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2021-11-21 8:23 下午
 */
public class Offer30_1 {


    private Stack<Integer> dataStack; // 数据栈
    private Stack<Integer> minStack; // 辅助栈，记录每次有元素进栈后或者出栈后，元素的最小值

    /**
     * initialize your data structure here.
     */
    public Offer30_1() {
        // 初始化辅助栈和数据栈
        dataStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        // 如果记录当前数据栈中最小值的辅助栈为空，或者最小值小于 x，则将 x 设置为最小值，即进辅助栈
        if (minStack.isEmpty() || minStack.peek() > x) {
            minStack.push(x);
        } else {// 如果数据栈中当前最小值 < x, 则继续将最小值设置为上次的最小值
            minStack.push(minStack.peek());
        }
        dataStack.push(x);// 数据栈，进栈
    }

    public void pop() {
        minStack.pop();// 辅助栈，栈出栈
        dataStack.pop();// 数据栈，出栈
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }

}
