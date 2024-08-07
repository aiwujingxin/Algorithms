package leetcode.problems;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/29 11:58
 */
public class LeetCode2415 {

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            if (depth % 2 == 1) {
                List<TreeNode> list = new ArrayList<>(queue);
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    int t = list.get(left).val;
                    list.get(left).val = list.get(right).val;
                    list.get(right).val = t;
                    left++;
                    right--;
                }
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
            depth++;
        }
        return root;
    }
}
