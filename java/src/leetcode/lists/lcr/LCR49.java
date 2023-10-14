package leetcode.lists.lcr;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 10:40
 */
public class LCR49 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
