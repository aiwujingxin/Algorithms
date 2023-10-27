package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/27 15:19
 */
public class LeetCode106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe) {
        if (ps < 0 || ps > pe || is < 0 || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int index = is;
        int leftLen = 0;
        while (index < inorder.length && inorder[index] != postorder[pe]) {
            index++;
            leftLen++;
        }
        root.left = buildTree(inorder, is, index - 1, postorder, ps, ps + leftLen - 1);
        root.right = buildTree(inorder, index + 1, ie, postorder, ps + leftLen, pe - 1);
        return root;
    }
}
