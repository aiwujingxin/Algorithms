package leetcode.lists.hot100;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/19 13:28
 */
public class LeetCode155 {

    int min;
    Stack<Integer> stack;

    public LeetCode155() {
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
