package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/23 16:45
 */
public class LeetCode250_v2 {
    int cnt;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root, -1);
        return cnt;
    }

    private boolean dfs(TreeNode root, int preVal) {
        if (root == null) {
            return true;
        }
        // 这里的left是指，左子树所有值相同，并且和root的值相同
        boolean left = dfs(root.left, root.val);
        boolean right = dfs(root.right, root.val);
        if (left && right) {
            cnt++;
            return root.val == preVal;
        }
        return false;
    }
}
