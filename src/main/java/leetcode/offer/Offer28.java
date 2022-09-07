package leetcode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-21 7:02 下午
 */
public class Offer28 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L == null) {
            return false;
        }
        if (R == null) {
            return false;
        }
        if (L.val != R.val) {
            return false;
        }

        return helper(L.left, R.right) && helper(L.right, R.left);
    }
}
