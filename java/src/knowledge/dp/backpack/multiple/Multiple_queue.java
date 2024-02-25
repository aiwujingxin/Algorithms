package knowledge.dp.backpack.multiple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/25 22:17
 * @see leetcode.problems.LeetCode239_queue
 */
public class Multiple_queue implements MultiplePack {

    @Override
    public int backPack(int[] weights, int[] values, int[] counts, int capacity) {
        int n = weights.length;
        int[] dp = new int[capacity + 1];
        int[] pre = new int[capacity + 1];
        // 构建单调队列
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int weight = weights[i];
            int value = values[i];
            int count = counts[i];
            for (int j = 0; j < weight; j++) {
                queue.clear();
                for (int k = j; k <= capacity; k += weight) {
                    pre[k] = dp[k];
                    while (!queue.isEmpty() && pre[queue.peekLast()] - (queue.peekLast() - j) / weight * value <= pre[k] - (k - j) / weight * value) {
                        queue.pollLast();
                    }
                    queue.addLast(k);
                    if (!queue.isEmpty() && queue.getFirst() < k - count * weight) {
                        queue.pollFirst();
                    }
                    if (!queue.isEmpty()) {
                        dp[k] = Math.max(dp[k], pre[queue.getFirst()] + (k - queue.getFirst()) / weight * value);
                    }
                }
            }
        }
        return dp[capacity];
    }
}
