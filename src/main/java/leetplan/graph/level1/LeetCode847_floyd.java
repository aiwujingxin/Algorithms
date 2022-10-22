package leetplan.graph.level1;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/20 23:39
 */
public class LeetCode847_floyd {

    public int shortestPathLength(int[][] graph) {
        // 使用Floyd算法计算点对之间的最短路径
        int n = graph.length;
        int MAX = Integer.MAX_VALUE / 2;
        int[][] d = new int[n][n];
        for (int[] arr : d) {
            Arrays.fill(arr, MAX);
        }
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                d[i][j] = 1;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

        // dp[state][i],state表示当前图的遍历状态,i代表当前点的遍历位置
        int[][] dp = new int[1 << n][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, MAX);
        }

        for (int state = 1; state < dp.length; state++) {
            if ((state & (state - 1)) == 0) {
                int u = Integer.bitCount((state & (-state)) - 1);
                dp[state][u] = 0;
            } else {
                // 先枚举当前节点
                for (int i = 0; i < n; i++) {
                    // 再枚举上一个状态
                    for (int j = 0; j < n; j++) {
                        if ((state & (1 << j)) == 0 || i == j) {
                            continue;
                        }
                        int prevState = state ^ (1 << i);
                        dp[state][i] = Math.min(dp[state][i], dp[prevState][j] + d[i][j]);
                    }
                }
            }
        }
        int ans = MAX;
        for (int i = 0; i < n; i++) {
            ans = Math.min(dp[dp.length - 1][i], ans);
        }
        return ans;
    }
}
