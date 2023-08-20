package leetcode;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2021-08-05 2:24 上午
 */
public class LeetCode150 {


    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            switch (s) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    Integer one = stack.pop();
                    Integer two = stack.pop();
                    stack.push(two - one);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b / a);
                }
                default -> stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
