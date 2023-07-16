package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/12 00:10
 */
public class LeetCode114 {

    public void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /* 后序遍历位置 */
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

    }
}
