package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/17 16:31
 */
public class LeetCode606 {

    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        if (root.left == null && root.right == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            return root.val + "(" + tree2str(root.left) + ")";
        }
        return root.val + "(" + tree2str(root.left) + ")(" + tree2str(root.right) + ")";
    }
}
