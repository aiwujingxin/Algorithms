package leetcode;

import common.TreeNode;

import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/16 15:41
 */
public class LeetCode230_stack {

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) {
                return root.val;
            }
            root = root.right;
        }
    }
}
