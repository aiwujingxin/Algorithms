package leetcode.problems;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1609 {

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int pre = queue.peek().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (step % 2 == node.val % 2) {
                    return false;
                }
                if (i > 0 && step % 2 == 0 && pre >= node.val) {
                    return false;
                }
                if (i > 0 && step % 2 == 1 && pre <= node.val) {
                    return false;
                }
                pre = node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            step++;
        }
        return true;
    }
}
