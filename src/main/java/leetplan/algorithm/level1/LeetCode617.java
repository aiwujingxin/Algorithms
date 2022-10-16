package leetplan.algorithm.level1;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/12 22:22
 */
public class LeetCode617 {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }
}
