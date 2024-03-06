package leetcode.problems;

import common.*;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/6 16:08
 */
public class LeetCode1123_lca {

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                set.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.left);
                }
            }
        }
        return lca(root, set);
    }

    private TreeNode lca(TreeNode root, Set<TreeNode> set) {
        if (root == null) {
            return null;
        }
        if (set.contains(root)) {
            return root;
        }
        TreeNode left = lca(root.left, set);
        TreeNode right = lca(root.right, set);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }
}
