package leetcode.problems;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jingxinwu
 * @date 2021-08-05 2:24 上午
 */
public class LeetCode150 {


    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(stack.pop() - stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    stack.push(stack.pop() / stack.pop());
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
