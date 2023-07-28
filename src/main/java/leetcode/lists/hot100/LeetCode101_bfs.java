package leetcode.lists.hot100;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/10 15:49
 */
public class LeetCode101_bfs {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if (right == null && left == null) {
                continue;
            }

            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }

            queue.add(left.left);
            queue.add(right.right);

            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
