package LeetCode;

/**
 * @author jingxinwu
 * @date 2021-12-19 6:49 PM
 */
public class LeetCode538 {

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}
