package basic.structure.tree.measure;

import basic.structure.tree.*;
import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/15 23:05
 * @see leetcode.problems.LeetCode222
 */
public class Amount implements Count {

    @Override
    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }
}
