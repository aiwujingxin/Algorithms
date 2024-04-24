package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 21:47
 */
public class LeetCode71 {

    public String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return "/";
        }
        String[] str = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : str) {
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!"".equals(s) && !".".equals(s)) {
                stack.push(s);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }
        return sb.toString();
    }
}
