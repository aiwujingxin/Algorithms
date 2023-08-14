package leetcode.lists.classic;

import common.TreeNode;

/**
 * @author jingxinwu
 * @date 2021-12-05 3:32 下午
 */
public class Number1712 {

    TreeNode resultNode;
    TreeNode pre = null;

    public TreeNode convertBiNode(TreeNode root) {
        inOrder(root);
        return resultNode;
    }

    private void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            visit(node);
            inOrder(node.right);
        }
    }

    private void visit(TreeNode cur) {
        if (pre == null) {
            resultNode = cur;
        } else {
            cur.left = null;
            pre.right = cur;
        }
        pre = cur;
    }

}
