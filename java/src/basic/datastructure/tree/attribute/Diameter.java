package basic.datastructure.tree.attribute;

import basic.datastructure.tree.*;
import common.*;
import leetcode.problems.LeetCode543;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/7 12:29
 * @see LeetCode543
 */
public class Diameter implements Attribute {

    int maxDiameter = 0;

    @Override
    public int count(TreeNode root) {
        maxDepth(root);
        return maxDiameter;
    }

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        return 1 + Math.max(leftMax, rightMax);
    }
}
