package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/14 22:26
 */
public class LeetCode145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == pre) {
                list.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.add(root);
                root = root.right;
            }
        }
        return list;
    }
}
