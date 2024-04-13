package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/12 13:04
 */
public class LeetCode99 {

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root);
            root = root.right;
        }
        TreeNode a = null;
        TreeNode b = null;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i).val <= list.get(i - 1).val) {
                if (a == null) {
                    a = list.get(i);
                } else {
                    b = list.get(i);
                }
            }
            if (i + 1 < list.size() && list.get(i).val >= list.get(i + 1).val) {
                if (a == null) {
                    a = list.get(i);
                } else {
                    b = list.get(i);
                }
            }
        }
        if (a == null || b == null) {
            return;
        }
        int t = a.val;
        a.val = b.val;
        b.val = t;
    }
}
