package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 14:38
 */
public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe || is > ie) {
            return null;
        }
        int index = is;
        int ll = 0;
        while (index < ie && inorder[index] != preorder[ps]) {
            index++;
            ll++;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        root.left = buildTree(preorder, ps + 1, pe + ll, inorder, is, index - 1);
        root.right = buildTree(preorder, ps + ll + 1, pe, inorder, index + 1, ie);
        return root;
    }
}
