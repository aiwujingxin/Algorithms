package leetcode.lists.lcr;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 10:22
 */
public class LCR43 {

    class CBTInserter {

        Deque<TreeNode> candidate = new ArrayDeque<>();
        TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (!(node.left != null && node.right != null)) {
                    candidate.add(node);
                }
            }
        }

        public int insert(int val) {
            TreeNode child = new TreeNode(val);
            TreeNode node = candidate.peek();
            if (node.left == null) {
                node.left = child;
            } else if (node.right == null) {
                node.right = child;
                candidate.removeFirst();
            }
            candidate.offer(child);
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

}
