package leetcode.lists.hot100;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/10 15:59
 */
public class LeetCode104_bfs {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }
        return count;
    }
}
