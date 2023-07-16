package leetcode.lists.offer;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-11-21 6:37 下午
 */
public class Offer27 {

    //镜像树
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;

    }
}
