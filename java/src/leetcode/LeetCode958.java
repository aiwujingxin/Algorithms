package leetcode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/29 11:16
 */
public class LeetCode958 {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode pre = root;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && pre == null) {
                    return false;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                pre = node.left;
                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.right != null && pre == null) {
                    return false;
                }
                pre = node.right;
            }
        }
        return true;
    }
}
