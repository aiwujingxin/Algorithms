package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-07-04 8:34 下午
 */
public class LeetCode98 {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        TreeNode one = new TreeNode(4);
        TreeNode two = new TreeNode(6);
        root.left = one;
        root.right = two;

        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(7);
        two.left = three;
        two.right = four;

        System.out.println(new LeetCode98().isValidBST(root));

    }

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
