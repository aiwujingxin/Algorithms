package leetcode.lists.classic;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 17:29
 */
public class Number0412 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, sum);
        ret += pathSum(root.left, sum);
        ret += pathSum(root.right, sum);
        return ret;
    }

    public int rootSum(TreeNode root, int sum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == sum) {
            ret++;
        }

        ret += rootSum(root.left, sum - val);
        ret += rootSum(root.right, sum - val);
        return ret;
    }

}
