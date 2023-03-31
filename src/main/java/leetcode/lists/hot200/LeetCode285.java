package leetcode.lists.hot200;

import common.TreeNode;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/12 16:13
 */
public class LeetCode285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }

    // == dfs==
    boolean flag;
    TreeNode res;

    public TreeNode inorderSuccessor_dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        return dfs(root, p);
    }

    private TreeNode dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        dfs(root.left, p);
        if (flag) {
            res = root;
            flag = false;
        }
        if (root == p) {
            flag = true;
        }
        dfs(root.right, p);
        return res;
    }
}
