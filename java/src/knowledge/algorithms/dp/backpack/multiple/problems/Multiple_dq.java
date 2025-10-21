package knowledge.algorithms.dp.backpack.multiple.problems;

import knowledge.algorithms.dp.backpack.multiple.MultiplePack;
import leetcode.problems.LeetCode239_dq;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/25 22:17
 * @description 多重背包 单调队列优化
 * @see LeetCode239_dq
 * @see 6.cpp
 */
public class Multiple_dq implements MultiplePack {

    @Override
    public int backPack(int[] C, int[] W, int[] K, int V) {
        int N = C.length;
        int[] dp = new int[V + 1];
        int[] pre = new int[V + 1];
        // 构建单调队列
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int c = C[i];
            int w = W[i];
            int m = K[i];
            for (int j = 0; j < c; j++) {
                q.clear();
                for (int k = j; k <= V; k += c) {
                    pre[k] = dp[k];
                    while (!q.isEmpty() && pre[q.peekLast()] - (q.peekLast() - j) / c * w <= pre[k] - (k - j) / c * w) {
                        q.pollLast();
                    }
                    q.addLast(k);
                    if (q.getFirst() < k - m * c) {
                        q.pollFirst();
                    }
                    if (!q.isEmpty()) {
                        dp[k] = Math.max(dp[k], pre[q.getFirst()] + (k - q.getFirst()) / c * w);
                    }
                }
            }
        }
        return dp[V];
    }
}
