package leetcode.lists.offerII;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 17:10
 */
public class Offer54 {

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
