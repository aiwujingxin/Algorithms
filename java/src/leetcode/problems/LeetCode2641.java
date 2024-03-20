package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/2 21:53
 */
public class LeetCode2641 {


    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.val = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int sum = 0;
            List<TreeNode> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node);
                if (node.left != null) {
                    queue.add(node.left);
                    sum += node.left.val;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    sum += node.right.val;
                }

            }
            //处理下一层
            for (TreeNode node : level) {
                int left = 0;
                int right = 0;
                if (node.left != null) {
                    left = sum - (node.right == null ? 0 : node.right.val) - node.left.val;
                }
                if (node.right != null) {
                    right = sum - (node.left == null ? 0 : node.left.val) - node.right.val;
                }
                if (node.left != null) {
                    node.left.val = left;
                }
                if (node.right != null) {
                    node.right.val = right;
                }
            }
        }
        return root;
    }
}
