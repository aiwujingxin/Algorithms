package leetcode.lists.hot200;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/5/28 23:10
 */
public class LeetCode333_dp_tree {
    int res = 0;

    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return res;
    }

    //以当前节点为根是否是BST
    int[] dfs(TreeNode root) {
        //空节点也是一颗BST
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        // [0]是否BST
        // [1]当前为根的BST最小值
        // [2]当前为根的BST最大值
        // [3]该BST节点总数
        // 左右子树是BST，并且val满足大于左最大值，小于右最小值
        int[] cur = new int[4];
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            cur[0] = 1;//置1 true
            cur[1] = Math.min(left[1], root.val);//更新最小值
            cur[2] = Math.max(right[2], root.val);//更新最大值
            cur[3] = left[3] + right[3] + 1;//更新节点数量
            res = Math.max(cur[3], res);//更新全局变量
        }
        return cur;
    }
}
