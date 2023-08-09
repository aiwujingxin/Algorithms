package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/29 13:41
 */
public class LeetCode919 {


    class CBTInserter {

        Queue<TreeNode> candidate;
        TreeNode root;

        public CBTInserter(TreeNode root) {

            this.candidate = new ArrayDeque<>();
            this.root = root;

            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (!(node.left != null && node.right != null)) {
                    candidate.offer(node);
                }
            }
        }

        public int insert(int val) {
            TreeNode child = new TreeNode(val);
            TreeNode node = candidate.peek();
            int ret = node.val;
            if (node.left == null) {
                node.left = child;
            } else {
                node.right = child;
                candidate.poll();
            }
            candidate.offer(child);
            return ret;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
