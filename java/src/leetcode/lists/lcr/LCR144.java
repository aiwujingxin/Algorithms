package leetcode.lists.lcr;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 21:59
 */
public class LCR144 {

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
