package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/29 00:09
 */
public class LeetCode513_dfs {
    int curVal = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        int curHeight = 0;
        dfs(root, 0);
        return curVal;
    }

    public void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
    }
}
