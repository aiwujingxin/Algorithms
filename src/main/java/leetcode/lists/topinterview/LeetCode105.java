package leetcode.lists.topinterview;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/23 20:21
 */
public class LeetCode105 {


    //preorder = [3,9,20,15,7],
    //inorder = [9,3,15,20,7]

    //fix case
    //[1,2,3]
    //[3,2,1]

    public static void main(String[] args) {
        System.out.println(new LeetCode105().buildTree(new int[]{1, 2, 3}, new int[]{3, 2, 1}));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    public TreeNode buildTree(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start > p_end || i_start > i_end) {
            return null;
        }

        int root_val = preorder[p_start];

        TreeNode root = new TreeNode(root_val);

        int leftLen = 0;
        int index = i_start;

        while (index < inorder.length) {
            if (inorder[index] == root_val) {
                break;
            }
            index++;
            leftLen++;
        }

        //fixed
        root.left = buildTree(preorder, p_start + 1, p_start + leftLen, inorder, i_start, index - 1);
        root.right = buildTree(preorder, p_start + leftLen + 1, p_end, inorder, index + 1, i_end);
        return root;
    }
}
