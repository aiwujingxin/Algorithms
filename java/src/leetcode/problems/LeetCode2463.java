package leetcode.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/10/1 20:46
 */

public class LeetCode2463 {

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int m = robot.size(), n = factory.length;
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(dp[i], (long) 1e18);
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                long cost = 0;
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; j - k >= 0 && k <= factory[i - 1][1]; k++) {
                    cost += Math.abs(robot.get(j - k) - factory[i - 1][0]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k] + cost);
                }
            }
        }
        return dp[n][m];
    }
}
