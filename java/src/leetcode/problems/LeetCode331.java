package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/10 21:46
 */
public class LeetCode331 {

    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<>();
        for (String node : preorder.split(",")) {
            while (!stack.isEmpty() && stack.peek().equals("#") && node.equals("#")) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(node);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    boolean valid = true;
    int pos;

    public boolean isValidSerialization_v1(String preorder) {
        pos = 0;
        String[] tokens = preorder.split(",");
        dfs(tokens);
        return valid && pos == tokens.length;
    }

    public void dfs(String[] tokens) {
        if (pos >= tokens.length) {
            valid = false;
            return;
        }
        if ("#".equals(tokens[pos])) {
            pos++;
            return;
        }
        pos++;
        // 左
        dfs(tokens);
        // 右
        dfs(tokens);
    }
}
