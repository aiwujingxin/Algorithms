package leetcode;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/10 21:43
 */
public class LeetCode513 {

    public int findBottomLeftValue(TreeNode root) {
        int ret = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            ret = node.val;
        }
        return ret;
    }
}
