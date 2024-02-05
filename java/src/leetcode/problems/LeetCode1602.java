package leetcode.problems;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1602 {

    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (node == u) {
                    if (i == size - 1) {
                        return null;
                    } else {
                        return queue.peek();
                    }
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return null;
    }
}
