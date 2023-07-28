package leetcode.lists.offerII;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 16:29
 */
public class Offer49 {

    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 0);
        return sum;

    }

    private void dfs(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        int s = (val * 10 + root.val);
        if (root.left == null && root.right == null) {
            sum += s;
            return;
        }
        dfs(root.left, s);
        dfs(root.right, s);
    }
}
