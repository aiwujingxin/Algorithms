package leetcode.lists.topinterview;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 23:55
 */
public class LeetCode150 {

    public int evalRPN(String[] tokens) {

        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {

            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    Integer one = stack.pop();
                    Integer two = stack.pop();
                    stack.push(two - one);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer a = stack.pop();
                    Integer b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
