package leetcode.lists.hot100;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/6 23:40
 */
public class LeetCode94_iteration {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
