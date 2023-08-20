package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/2 18:16
 */
public class LeetCode1457 {

    int ret = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        tranverse(root, 0);
        return ret;
    }

    public void tranverse(TreeNode root, int temp) {
        if (root == null) {
            return;
        }
        int n = temp ^ (1 << root.val);
        if (root.left == null && root.right == null) {
            if (n == 0 || (n & (n - 1)) == 0) {
                ret++;
            }
        }
        tranverse(root.left, n);
        tranverse(root.right, n);
    }
}
