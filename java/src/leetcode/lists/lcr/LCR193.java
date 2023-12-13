package leetcode.lists.lcr;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-11-27 3:01 下午
 */
public class LCR193 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
