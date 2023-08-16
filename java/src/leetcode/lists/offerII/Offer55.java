package leetcode.lists.offerII;

import common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/25 17:11
 */
public class Offer55 {

    class BSTIterator {

        private final Deque<TreeNode> stack;
        private TreeNode cur;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new LinkedList<>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ret = cur.val;
            cur = cur.right;
            return ret;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
