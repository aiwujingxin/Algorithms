package leetcode.lists.lcp;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/23 17:38
 */
public class LCP64 {
    public int closeLampInTree(TreeNode root) {
        return dfs(root)[0];
    }

    /*
     * dp[i][0]表示在i这个结点，使本结点及其左右子树灯泡全关所需的最小操作次数；
     * dp[i][1]表示在i这个结点，使本结点及其左右子树灯泡全开所需的最小操作次数；
     * dp[i][2]表示在i这个结点，使本结点开、左右子树关所需的最小操作次数；
     * dp[i][3]表示在i这个结点，使本结点关、左右子树开所需的最小操作次数；
     * */
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0, 0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int on = root.val;
        int off = (root.val & 1);
        int[] dp = new int[4];
        //状态转移方程
        dp[0] = min(left[0] + right[0] + on, left[1] + right[1] + off + 1, left[2] + right[2] + off + 1, left[3] + right[3] + on + 2);
        dp[1] = min(left[0] + right[0] + on + 1, left[1] + right[1] + off, left[2] + right[2] + off + 2, left[3] + right[3] + on + 1);
        dp[2] = min(left[0] + right[0] + off, left[1] + right[1] + on + 1, left[2] + right[2] + on + 1, left[3] + right[3] + off + 2);
        dp[3] = min(left[0] + right[0] + off + 1, left[1] + right[1] + on, left[2] + right[2] + on + 2, left[3] + right[3] + off + 1);
        return dp;
    }

    private int min(int a, int b, int c, int d) {
        return Math.min(Math.min(Math.min(a, b), c), d);
    }
}
