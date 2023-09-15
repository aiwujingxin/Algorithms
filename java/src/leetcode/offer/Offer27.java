package leetcode.offer;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 21:59
 */
public class Offer27 {

    public TreeNode mirrorTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
