package leetcode.problems;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 11/24/25 17:19
 */
public class LeetCode1145 {
    private TreeNode xNode; // 用来存放值为 x 的节点

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        findX(root, x);
        int leftSize = countNodes(xNode.left);
        int rightSize = countNodes(xNode.right);
        int parentSize = n - leftSize - rightSize - 1;
        if (leftSize > n / 2) {
            return true;
        }
        if (rightSize > n / 2) {
            return true;
        }
        return parentSize > n / 2;
    }

    private int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    private void findX(TreeNode node, int x) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            this.xNode = node;
            return;
        }
        findX(node.left, x);
        findX(node.right, x);
    }
}
