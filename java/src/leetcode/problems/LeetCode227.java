package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/28 11:06
 */
public class LeetCode227 {

    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        char pre = '+';
        int num = 0;
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (isDigit(chars[i])) {
                num = num * 10 + chars[i] - '0';
            }
            if (!isDigit(s.charAt(i)) || i == n - 1) {
                switch (pre) {
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
                }
                pre = s.charAt(i);
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    private boolean isDigit(char token) {
        return token >= '0' && token <= '9';
    }
}
