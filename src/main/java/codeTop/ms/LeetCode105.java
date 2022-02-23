package codeTop.ms;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2022-02-17 4:35 PM
 */
public class LeetCode105 {

    public static void main(String[] args) {
        System.out.println(new LeetCode105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }
        //fix 传length
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }


    public TreeNode helper(int[] preorder, int p_l, int p_r, int[] inorder, int i_l, int i_r) {
        if (p_l < 0 || p_r > preorder.length - 1 || i_l < 0 || i_r > inorder.length - 1 || i_l == i_r) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[p_l]);

        int cur = preorder[p_l];

        int index = 0;

        while (index < inorder.length && inorder[index] != cur) {
            index++;
        }

        int left_len = index - i_l;

        node.left = helper(preorder, p_l + 1, p_l + left_len + 1, inorder, i_l, index);

        //fix p_l + left_len + 1
        node.right = helper(preorder, p_l + left_len + 1, p_r, inorder, index + 1, i_r);
        return node;
    }
}
