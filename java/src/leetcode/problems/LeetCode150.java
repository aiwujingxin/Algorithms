package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/1 23:08
 */
public class LeetCode150 {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int c = stack.pop();
                    int d = stack.pop();
                    stack.push(d - c);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
