package leetcode.problems;

import common.TreeNode;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 14:08
 */
public class LeetCode230 {

    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (k-- == 1) {
                return root.val;
            }
            root = root.right;
        }
        return -1;
    }
}
