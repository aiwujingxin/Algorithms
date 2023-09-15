package leetcode.offer;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 13:29
 */
public class Offer7 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start > p_end || i_start > i_end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        int index = i_start;
        int left_len = 0;
        while (index < i_end && inorder[index] != preorder[p_start]) {
            index++;
            left_len++;
        }
        root.left = buildTree(preorder, p_start + 1, p_start + left_len, inorder, i_start, index - 1);
        root.right = buildTree(preorder, p_start + left_len + 1, p_end, inorder, index + 1, i_end);
        return root;
    }
}
