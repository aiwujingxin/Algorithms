package leetcode.hot100;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 01:55
 */
public class LeetCode114_pre {

    /**
     *      1
     *   2     5
     * 3   4      6
     * */

    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}