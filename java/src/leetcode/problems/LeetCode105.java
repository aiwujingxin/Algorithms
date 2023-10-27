package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 15:03
 */
public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps < 0 || ps > pe || is < 0 || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        int index = is;
        int len = 0;

        while (index < inorder.length && inorder[index] != preorder[ps]) {
            index++;
            len++;
        }
        root.left = buildTree(preorder, ps + 1, ps + len, inorder, is, index - 1);
        root.right = buildTree(preorder, ps + len + 1, pe, inorder, index + 1, ie);
        return root;
    }
}
