package leetplan.datastructure;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/18 00:13
 */
public class LeetCode700 {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
}
