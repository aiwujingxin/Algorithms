package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 10/21/25 21:47
 */
public class LeetCode2463_dq {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        robot = new ArrayList<>(robot);
        Collections.sort(robot);
        int m = factory.length;
        int n = robot.size();
        final long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[m + 1][n + 1];
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            int pos = factory[i - 1][0], cap = factory[i - 1][1];
            long[] sum = new long[n + 1];
            for (int j = 1; j <= n; j++) sum[j] = sum[j - 1] + Math.abs((long) pos - robot.get(j - 1));
            dp[i][0] = 0;
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (dp[i - 1][j - 1] != INF) {
                    while (!dq.isEmpty() && dp[i - 1][dq.peekLast()] - sum[dq.peekLast()] > dp[i - 1][j - 1] - sum[j - 1])
                        dq.pollLast();
                    dq.addLast(j - 1);
                }
                while (!dq.isEmpty() && dq.peekFirst() < j - cap) {
                    dq.pollFirst();
                }
                if (!dq.isEmpty()) {
                    int t = dq.peekFirst();
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][t] - sum[t] + sum[j]);
                }
            }
        }
        return dp[m][n];
    }
}
