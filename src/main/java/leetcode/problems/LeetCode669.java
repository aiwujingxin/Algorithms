package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/14 17:48
 */
public class LeetCode669 {


    public TreeNode trimBST(TreeNode root, int low, int high) {

        if (root == null) {
            return null;
        }


        root.left = trimBST(root.left, low, high);

        // logic

        if (root.val < low || root.val > high) {

        }

        root.right = trimBST(root.right, low, high);

        return root;

    }
}
