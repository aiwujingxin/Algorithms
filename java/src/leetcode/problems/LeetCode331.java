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
}
