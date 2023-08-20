package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/18 15:22
 */
public class LeetCode1008 {

    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int start, int end) {

        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(preorder[start]);
        }
        TreeNode root = new TreeNode(preorder[start]);
        int index = start + 1;
        while (index <= end && preorder[index] < preorder[start]) {
            index++;
        }
        root.left = dfs(preorder, start + 1, index - 1);
        root.right = dfs(preorder, index, end);
        return root;
    }
}
