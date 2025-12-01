package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/16 14:41
 */
public class LeetCode106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] in, int is, int ie, int[] p, int ps, int pe) {
        if (is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(p[pe]);
        int i = is;
        int len = 0;
        while (i < ie && in[i] != p[pe]) {
            i++;
            len++;
        }
        root.left = buildTree(in, is, i - 1, p, ps, ps + len - 1);
        root.right = buildTree(in, i + 1, ie, p, ps + len, pe - 1);
        return root;
    }
}
