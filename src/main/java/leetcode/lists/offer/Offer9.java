package leetcode.lists.offer;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-11-19 9:59 下午
 */
public class Offer9 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Offer9() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        if (stack1.isEmpty()) {
            stack1.push(value);
        }
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

}
