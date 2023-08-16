package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/11 17:57
 */
public class LeetCode1123 {


    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }

        // 获取当前节点的左右子树的最大深度
        int leftMaxDepth = getMaxDepth(root.left);
        int rightMaxDepth = getMaxDepth(root.right);

        // 如果两边最大深度相同，则这个节点就是结果
        if (leftMaxDepth == rightMaxDepth) {
            return root;
        }

        // 不相等，那就去深度大的子树那边继续找
        if (leftMaxDepth > rightMaxDepth) {
            return lcaDeepestLeaves(root.left);
        }
        return lcaDeepestLeaves(root.right);
    }

    public int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }
}
