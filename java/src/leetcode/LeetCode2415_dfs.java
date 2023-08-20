package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/29 12:57
 */
public class LeetCode2415_dfs {

    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, 1); // 注意传入的起始层数，因为首次进入了下层，所以传入为 1
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, int level) {
        if (left == null || right == null) {
            return;
        }

        if (level % 2 == 1) {
            int tmp = left.val;
            left.val = right.val;
            right.val = tmp;
        }

        dfs(left.left, right.right, level + 1);
        dfs(left.right, right.left, level + 1);
    }
}
