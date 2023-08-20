package leetcode;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/15 23:10
 */
public class LeetCode20 {

    //fx case
    //"(])"

    public static void main(String[] args) {
        System.out.println(new LeetCode20().isValid("(])"));
    }

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
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
