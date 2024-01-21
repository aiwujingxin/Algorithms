package leetcode.problems;

import common.TreeNode;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2024-01-18 22:16:02
 */
public class LeetCode1261 {

    class FindElements {

        TreeNode root;
        HashSet<Integer> set = new HashSet<>();

        public FindElements(TreeNode root) {
            this.root = root;
            if (root == null) {
                return;
            }
            root.val = 0;
            set.add(0);
            dfs(root);
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                root.left.val = 2 * root.val + 1;
                set.add(root.left.val);
            }
            if (root.right != null) {
                root.right.val = 2 * root.val + 2;
                set.add(root.right.val);
            }
            dfs(root.left);
            dfs(root.right);
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}
