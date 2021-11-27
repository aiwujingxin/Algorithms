package offer;

/**
 * @author jingxinwu
 * @date 2021-11-21 6:22 下午
 */
public class Offer26 {


    //子树
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


    public boolean isSubStructureV2(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    boolean recur(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}
