package leetcode.problems;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/6 12:55
 */
public class LeetCode331 {

    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.isEmpty()) {
            return false;
        }
        String[] strings = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String node : strings) {
            if ("#".equals(node)) {
                //连续消除
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            stack.push(node);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}
