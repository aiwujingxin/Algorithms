package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/17 21:47
 */
public class LeetCode623_bfs {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelNum = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> level = new ArrayList<>();
            while (size > 0) {
                TreeNode node = queue.poll();
                level.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            levelNum++;
            if (levelNum == depth) {
                for (TreeNode treeNode : level) {
                    TreeNode left = treeNode.left;
                    TreeNode right = treeNode.right;
                    treeNode.left = new TreeNode(val);
                    treeNode.right = new TreeNode(val);
                    treeNode.left.left = left;
                    treeNode.right.right = right;
                }
                return root;
            }
        }
        return root;
    }
}
