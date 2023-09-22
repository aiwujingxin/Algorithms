package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/16 00:02
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char aChar : chars) {
            if (aChar == '(' || aChar == '[' || aChar == '{') {
                stack.push(aChar);
            } else if (aChar == ')' || aChar == ']' || aChar == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                if ((aChar == ')' && stack.peek() == '(') || (aChar == ']' && stack.peek() == '[') || (aChar == '}' && stack.peek() == '{')) {
                    stack.pop();
                } else {
                    stack.push(aChar);
                }
            }
        }
        return stack.isEmpty();
    }
}
