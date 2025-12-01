package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 14:38
 */
public class LeetCode105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] p, int ps, int pe, int[] in, int is, int ie) {
        if (ps > pe || is > ie) return null;
        TreeNode root = new TreeNode(p[ps]);
        int i = is;
        int len = 0;
        while (i < ie && in[i] != p[ps]) {
            i++;
            len++;
        }
        root.left = buildTree(p, ps + 1, ps + len, in, is, i - 1);
        root.right = buildTree(p, ps + len + 1, pe, in, i + 1, ie);
        return root;
    }
}
