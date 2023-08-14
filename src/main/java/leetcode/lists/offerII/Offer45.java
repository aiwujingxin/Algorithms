package leetcode.lists.offerII;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 11:02
 */
public class Offer45 {

    int curVal = 0;
    int curHeight = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return curVal;
    }

    public void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
        if (height > curHeight) {
            curHeight = height;
            curVal = root.val;
        }
    }
}
