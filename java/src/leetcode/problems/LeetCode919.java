package leetcode.problems;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/29 13:41
 */
public class LeetCode919 {


    class CBTInserter {

        Queue<TreeNode> queue;

        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new LinkedList<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();
                if (node.left == null || node.right == null) {
                    queue.add(node);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }

        public int insert(int val) {
            TreeNode node = new TreeNode(val);
            if (queue.peek().left == null) {
                queue.peek().left = node;
                queue.add(node);
                return queue.peek().val;
            }
            if (queue.peek().right == null) {
                queue.peek().right = node;
                queue.add(node);
                return queue.poll().val;
            }
            return -1;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}
