package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/14 18:57
 */
public class LeetCode298 {

    int ans = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, root, 0);
        return ans;
    }

    private void dfs(TreeNode p, TreeNode parent, int length) {
        if (p == null) {
            return;
        }
        length = (p.val == parent.val + 1) ? length + 1 : 1;
        ans = Math.max(ans, length);
        dfs(p.left, p, length);
        dfs(p.right, p, length);
    }
}
