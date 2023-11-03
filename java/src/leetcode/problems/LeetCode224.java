package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 15:33
 */
public class LeetCode224 {

    public int calculate(String s) {
        return dfs(s, 0)[0];
    }

    public int[] dfs(String s, int index) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = 10 * num + c - '0';
            }
            if (c == '(') {
                int[] res = dfs(s, i + 1);
                num = res[0];
                i = res[1];
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                int pre;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        pre = stack.pop();
                        pre = pre * num;
                        stack.push(pre);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                    default:
                        break;
                }
                sign = c;
                num = 0;
            }
            if (c == ')') {
                return new int[]{sum(stack), i};
            }
        }
        return new int[]{sum(stack), s.length()};
    }

    private int sum(Stack<Integer> stack) {
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
