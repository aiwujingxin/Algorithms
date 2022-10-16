package leetplan.datastructure;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 14:07
 */
public class LeetCode226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
