package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/3 18:11
 */
public class LeetCode227 {

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char pre = '+';
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + s.charAt(i) - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (pre) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(-num);
                    case '*' -> stack.push(stack.pop() * num);
                    case '/' -> stack.push(stack.pop() / num);
                }
                pre = c;
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}