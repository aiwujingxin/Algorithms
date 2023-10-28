package leetcode.problems;

import common.TreeNode;

import java.util.Stack;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/28 11:53
 */
public class LeetCode173 {

    class BSTIterator {
        Stack<TreeNode> stack;
        TreeNode root;

        public BSTIterator(TreeNode root) {
            this.stack = new Stack<>();
            this.root = root;
        }

        public int next() {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            int val = root.val;
            root = root.right;
            return val;
        }

        public boolean hasNext() {
            return root != null || !stack.empty();
        }
    }
}
