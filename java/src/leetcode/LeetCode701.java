package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 00:16
 */
public class LeetCode701 {


    //https://leetcode.com/problems/insert-into-a-binary-search-tree/discuss/2029370/JAVA-0ms-100-faster-BOTH-recursive-and-iterative
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode curr = root, parent = null;
        while (curr != null) {
            parent = curr;
            if (val > curr.val) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        if (val > parent.val) {
            parent.right = new TreeNode(val);
        } else {
            parent.left = new TreeNode(val);
        }
        return root;
    }
}
