package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/28 16:43
 */
public class LeetCode1448 {

    int goodNum = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return goodNum;
        }
        dfs(root, root.val);
        return goodNum;
    }

    public void dfs(TreeNode node, int max) {
        if (node == null) {
            return;
        }
        if (node.val >= max) {
            goodNum++;
            max = node.val;
        }
        dfs(node.left, max);
        dfs(node.right, max);
    }
}
