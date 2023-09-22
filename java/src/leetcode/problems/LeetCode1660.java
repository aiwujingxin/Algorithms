package leetcode.problems;

import java.util.*;

import common.TreeNode;

public class LeetCode1660 {

    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            HashSet<TreeNode> set = new HashSet<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right != null) {
                    if (set.contains(node.right.right)) {
                        node.right = null;
                        break;
                    }
                    queue.add(node.right);
                    set.add(node.right);
                }
                if (node.left != null) {
                    if (set.contains(node.left.right)) {
                        node.left = null;
                        break;
                    }
                    queue.add(node.left);
                    set.add(node.left);
                }
            }
        }
        return root;
    }
}
