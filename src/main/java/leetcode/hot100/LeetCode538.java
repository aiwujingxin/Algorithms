package leetcode.hot100;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/8 12:57
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
