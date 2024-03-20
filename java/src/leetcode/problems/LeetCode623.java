package leetcode.problems;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/17 21:47
 */
public class LeetCode623 {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int step = 0;
        while (!queue.isEmpty()) {
            if (step + 2 == depth) {
                for (TreeNode treeNode : queue) {
                    TreeNode left = treeNode.left;
                    TreeNode right = treeNode.right;
                    treeNode.left = new TreeNode(val);
                    treeNode.right = new TreeNode(val);
                    treeNode.left.left = left;
                    treeNode.right.right = right;
                }
                return root;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            step++;
        }
        return root;
    }
}
