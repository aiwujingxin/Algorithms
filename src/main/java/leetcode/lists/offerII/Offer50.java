package leetcode.lists.offerII;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 16:42
 */
public class Offer50 {


    int cnt = 0;

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        rootSum(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return cnt;
    }

    public void rootSum(TreeNode root, long targetSum) {
        if (root == null) {
            return;
        }

        if (root.val == targetSum) {
            cnt++;
        }
        rootSum(root.left, targetSum - root.val);
        rootSum(root.right, targetSum - root.val);
    }
}
