package leetcode.lists.hot100;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/5 11:36
 */
public class LeetCode124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //每个节点的最大贡献值
        int left = Math.max(maxGain(node.left), 0);
        int right = Math.max(maxGain(node.right), 0);

        int path = node.val + left + right;
        //得到二叉树的最大路径和
        maxSum = Math.max(maxSum, path);
        // 返回节点的最大贡献值
        return node.val + Math.max(left, right);
    }
}
