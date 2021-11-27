package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-07-04 8:34 下午
 */
public class LeetCode98 {

    public boolean isValidBST(TreeNode root) {

        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {

        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }

}
