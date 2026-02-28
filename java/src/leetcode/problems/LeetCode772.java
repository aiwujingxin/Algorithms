package leetcode.problems;

import java.util.Stack;

/**
 * @author jingxinwu
 * @date 2022-02-14 10:53 PM
 */
public class LeetCode772 {

    int i = 0;

    public int calculate(String s) {
        return dfs(s);
    }

    private int dfs(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        while (i < s.length()) {
            char c = s.charAt(i++);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (c == '(') {
                num = dfs(s);
            }
            if ((!Character.isDigit(c) && c != ' ') || i == s.length()) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                if (c == ')') break; // 返回当前括号层级的结果
                num = 0;
                sign = c;
            }
            i++;
        }
        int res = 0;
        for (int val : stack) {
            res += val;
        }
        return res;
    }
}
