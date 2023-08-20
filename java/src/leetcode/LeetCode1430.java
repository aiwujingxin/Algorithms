package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/31 22:14
 */
public class LeetCode1430 {


    int[] arr;
    TreeNode root;

    public boolean isValidSequence(TreeNode root, int[] arr) {
        this.arr = arr;
        this.root = root;
        return dfs(root, 0);
    }

    private boolean dfs(TreeNode root, int i) {
        if (i == arr.length - 1 && root.left == null && root.right == null) {
            return root.val == arr[i];
        }
        if (i >= arr.length) {
            return false;
        }
        if (root.val != arr[i]) {
            return false;
        }
        boolean res = false;
        if (root.left != null) {
            res = dfs(root.left, i + 1);
        }
        if (root.right != null) {
            res = res || dfs(root.right, i + 1);
        }
        return res;
    }
}
