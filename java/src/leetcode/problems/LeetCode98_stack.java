package leetcode.problems;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 17:36
 */
public class LeetCode98_stack {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        double inorder = -Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
