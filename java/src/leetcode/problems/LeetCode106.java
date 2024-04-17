package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 14:41
 */
public class LeetCode106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (is > ie || ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int i = is;
        int ll = 0;
        while (i < ie && inorder[i] != postorder[pe]) {
            i++;
            ll++;
        }
        root.left = buildTree(inorder, is, i - 1, postorder, ps, ps + ll - 1);
        root.right = buildTree(inorder, i + 1, ie, postorder, ps + ll, pe - 1);
        return root;
    }
}
