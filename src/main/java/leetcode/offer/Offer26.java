package leetcode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-21 6:22 下午
 */
public class Offer26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (B == null) {
            return true;
        }

        if (A.val == B.val) {
            return true;
        }
        return isSubStructure(A.left, B.left) || isSubStructure(A.right, B.right);
    }
}
