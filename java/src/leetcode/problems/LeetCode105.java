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
        int rootVal = preorder[ps];
        TreeNode root = new TreeNode(rootVal);
        int index = is;
        while (index <= ie && inorder[index] != rootVal) {
            index++;
        }
        int leftSize = index - is;
        root.left = buildTree(preorder, ps + 1, ps + leftSize, inorder, is, index - 1);
        root.right = buildTree(preorder, ps + leftSize + 1, pe, inorder, index + 1, ie);
        return root;
    }
}
