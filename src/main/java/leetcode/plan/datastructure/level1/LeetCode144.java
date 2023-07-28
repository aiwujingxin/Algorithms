package leetcode.plan.datastructure.level1;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/15 21:53
 */
public class LeetCode144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}
