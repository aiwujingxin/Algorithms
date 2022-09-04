package leetCode.offer;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2021-11-21 8:06 下午
 */
public class Offer30 {

    Stack<Integer> A, B;

    //栈 A 中的最小元素始终对应栈 B 的栈顶元素
    public Offer30() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
