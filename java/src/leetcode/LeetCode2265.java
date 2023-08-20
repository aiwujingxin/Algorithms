package leetcode;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/14 21:35
 */
public class LeetCode2265 {


    int cnt;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return cnt;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int sum = (l[0] + r[0] + root.val);
        int nodeNum = (l[1] + r[1] + 1);
        if (sum / nodeNum == root.val) {
            cnt++;
        }
        return new int[]{sum, nodeNum};
    }
}
