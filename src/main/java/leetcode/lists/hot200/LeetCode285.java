package leetcode.lists.hot200;

import common.*;

import java.util.*;

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
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev == p) {
                return root;
            }
            prev = root;
            root = root.right;
        }
        return null;
    }
}
