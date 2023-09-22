package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/22 22:03
 */
public class LeetCode173 {

    class BSTIterator {

        private int idx;
        private final List<Integer> list;

        public BSTIterator(TreeNode root) {
            idx = 0;
            list = new ArrayList<>();
            inorderTraversal(root, list);
        }

        public int next() {
            return list.get(idx++);
        }

        public boolean hasNext() {
            return idx < list.size();
        }

        private void inorderTraversal(TreeNode root, List<Integer> arr) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left, arr);
            arr.add(root.val);
            inorderTraversal(root.right, arr);
        }
    }
}
