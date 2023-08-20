package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/23 16:45
 */
public class LeetCode250_v3 {

    int cnt;

    public int countUnivalSubtrees(TreeNode root) {
        dfs(root);
        return cnt;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }

        // 这里的left仅仅是指，左子树所有值相同，不管root的值
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);

        // cur指以root为根的树是不是所有值相同
        boolean l = true;
        boolean r = true;
        if (root.left != null && root.left.val != root.val) {
            l = false;
        }
        if (root.right != null && root.right.val != root.val) {
            r = false;
        }
        boolean cur = l && r && left && right;
        if (cur) {
            cnt++;
        }
        return cur;
    }
}
