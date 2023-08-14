package leetcode.problems;

import common.TreeNode;

import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/29 11:58
 */
public class LeetCode2415_bfs {

    public TreeNode reverseOddLevels(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    level.add(node.left);
                    queue.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                    queue.add(node.right);
                }
            }
            if (depth % 2 == 0) {
                int n = queue.size();
                for (int i = 0; i < n / 2; i++) {
                    TreeNode x = level.get(i);
                    TreeNode y = level.get(n - 1 - i);
                    int temp = x.val;
                    x.val = y.val;
                    y.val = temp;
                }
            }
            depth++;
        }
        return root;
    }
}
