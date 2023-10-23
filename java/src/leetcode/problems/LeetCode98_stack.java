package leetcode.problems;

import common.TreeNode;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 17:36
 */
public class LeetCode98_stack {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int pre = Integer.MIN_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }
}
