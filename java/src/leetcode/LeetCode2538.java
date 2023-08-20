package leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import common.TreeNode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/31 21:47
 */
public class LeetCode2538 {

    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            if (pq.size() < k) {
                pq.add(sum);
            } else if (pq.peek() < sum) {
                pq.poll();
                pq.add(sum);
            }
        }
        return pq.size() < k ? -1 : pq.peek();
    }
}
