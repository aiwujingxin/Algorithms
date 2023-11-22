package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/22 15:43
 */
public class LeetCode388 {

    public int lengthLongestPath(String input) {
        int n = input.length();
        int index = 0;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        while (index < n) {
            int depth = 1;
            while (index < n && input.charAt(index) == '\t') {
                index++;
                depth++;
            }
            boolean isFile = false;
            int len = 0;
            while (index < n && input.charAt(index) != '\n') {
                if (input.charAt(index) == '.') {
                    isFile = true;
                }
                len++;
                index++;
            }
            index++;

            while (stack.size() >= depth) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                len += stack.peek() + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                stack.push(len);
            }
        }
        return ans;
    }
}
