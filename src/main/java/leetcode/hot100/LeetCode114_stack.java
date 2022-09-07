package leetcode.hot100;

import common.TreeNode;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 00:49
 */
public class LeetCode114_stack {

    //https://www.youtube.com/watch?v=v2ob-ek9TgE
    /*
     *
     *      1
     *   2     5
     * 3  4      6
     * */

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (!stack.empty()) {
                cur.right = stack.peek();
            }
            cur.left = null;
        }
    }
}
