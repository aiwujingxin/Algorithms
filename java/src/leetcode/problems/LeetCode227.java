package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/6 13:26
 */
public class LeetCode227 {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        char perSign = '+';
        int num = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char c = chars[i];
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) || i == n - 1) {
                switch (perSign) {
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
                perSign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}
