package leetcode.hot100;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/15 23:34
 */
public class LeetCode105 {

    public static void main(String[] args) {
        System.out.println(new LeetCode105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start > p_end || i_start > i_end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[p_start]);
        int flag = i_start;
        int leftLen = 0;
        while (flag < inorder.length) {
            if (inorder[flag] == preorder[p_start]) {
                break;
            }
            flag++;
            leftLen++;
        }

        root.left = buildTree(preorder, p_start + 1, p_start + leftLen, inorder, i_start, flag - 1);
        root.right = buildTree(preorder, p_start + leftLen + 1, p_end, inorder, flag + 1, i_end);
        return root;
    }
}


