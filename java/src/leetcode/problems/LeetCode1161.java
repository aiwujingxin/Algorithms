package leetcode.problems;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/20 22:34
 */
public class LeetCode1161 {

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int max = Integer.MIN_VALUE;
        int ans = 0;
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (max < sum) {
                ans = level;
                max = sum;
            }
            level++;
        }
        return ans;
    }
}

