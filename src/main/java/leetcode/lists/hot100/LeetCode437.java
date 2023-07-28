package leetcode.lists.hot100;


import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/10 01:29
 */
public class LeetCode437 {

    //https://www.youtube.com/watch?v=1S7j67cREZ8
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return rootSum(root, targetSum) +// 首先写root节点
                // 扩展到其他节点
                pathSum(root.left, targetSum) +
                pathSum(root.right, targetSum);
    }

    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        if (root.val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - root.val);
        ret += rootSum(root.right, targetSum - root.val);
        return ret;
    }
}
