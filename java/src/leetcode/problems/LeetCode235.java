package leetcode.problems;

import common.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/5 14:38
 */
public class LeetCode235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int x = root.val;
        if (p.val < x && q.val < x) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > x && q.val > x) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
