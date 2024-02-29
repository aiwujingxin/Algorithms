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
    public int backPack(int[] C, int[] W, int[] S, int V) {
        int N = C.length;
        int[] dp = new int[V + 1];
        int[] pre = new int[V + 1];
        // 构建单调队列
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int c = C[i];
            int w = W[i];
            int m = S[i];
            for (int j = 0; j < c; j++) {
                q.clear();
                for (int k = j; k <= V; k += c) {
                    pre[k] = dp[k];
                    while (!q.isEmpty() && pre[q.peekLast()] - (q.peekLast() - j) / c * w <= pre[k] - (k - j) / c * w) {
                        q.pollLast();
                    }
                    q.addLast(k);
                    if (!q.isEmpty() && q.getFirst() < k - m * c) {
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
