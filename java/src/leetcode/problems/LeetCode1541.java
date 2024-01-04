package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/4 18:20
 */
public class LeetCode1541 {

    public int minInsertions(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && stack.size() >= 2) {
                char a = stack.pop();
                char b = stack.pop();
                if (a == ')' && b == '(') {

                } else {
                    stack.push(b);
                    stack.push(a);
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }
        int res = 0;
        // 出栈
        while (!stack.isEmpty()) {
            if (stack.pop() == '(') {
                res += 2;
            } else {
                if (stack.isEmpty()) {
                    res += 2;
                } else {
                    res += 1;
                    stack.pop();
                }
            }
        }
        return res;
    }
}
