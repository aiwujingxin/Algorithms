package knowledge.algorithms.dp.compressdp.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 9/25/25 00:44
 * @link <a href="https://vjudge.net/problem/HDU-3001"></a>
 */
public class Hdu3001 {

    public static class Main {
        static final int INF = Integer.MAX_VALUE / 2; // 防止加法溢出
        static int n, m;
        static int[][] graph;
        static int[][] dp;
        static int[] pow3;

        public static void main(String[] args) throws Exception {
            StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                n = (int) st.nval;
                st.nextToken();
                m = (int) st.nval;

                // 1. 初始化图和 pow3 数组
                graph = new int[n + 1][n + 1];
                for (int[] row : graph) {
                    Arrays.fill(row, INF);
                }
                for (int i = 0; i < m; i++) {
                    st.nextToken();
                    int u = (int) st.nval;
                    st.nextToken();
                    int v = (int) st.nval;
                    st.nextToken();
                    int cost = (int) st.nval;
                    // 存储边权较小者
                    graph[u][v] = Math.min(graph[u][v], cost);
                    graph[v][u] = Math.min(graph[v][u], cost);
                }

                pow3 = new int[n + 1];
                pow3[0] = 1;
                for (int i = 1; i <= n; i++) {
                    pow3[i] = pow3[i - 1] * 3;
                }

                // 2. 初始化 DP 数组
                // dp[state][j]: 状态为 state，当前在城市 j 的最小花费
                int maxState = pow3[n];
                dp = new int[maxState][n + 1];
                for (int[] row : dp) {
                    Arrays.fill(row, INF);
                }

                // 3. 设置起点
                // 从任意城市 i 出发，花费为 0
                // 状态为城市 i 访问 1 次，其他城市 0 次
                for (int i = 1; i <= n; i++) {
                    dp[pow3[i - 1]][i] = 0;
                }

                // 4. 状态转移
                for (int state = 1; state < maxState; state++) {
                    for (int i = 1; i <= n; i++) { // 当前终点为 i
                        if (dp[state][i] == INF) continue; // 如果此状态不可达，跳过
                        for (int j = 1; j <= n; j++) { // 尝试从 i 走到 j
                            // i 和 j 之间必须有路
                            if (graph[i][j] == INF) continue;
                            // 检查城市 j 的访问次数
                            // (state / pow3[j-1]) % 3 < 2  意味着 j 访问了 0 次或 1 次
                            if ((state / pow3[j - 1]) % 3 < 2) {
                                // 计算新状态：j 的访问次数 +1
                                int newState = state + pow3[j - 1];
                                int newCost = dp[state][i] + graph[i][j];
                                // 更新 dp 表
                                dp[newState][j] = Math.min(dp[newState][j], newCost);
                            }
                        }
                    }
                }
                // 5. 寻找最终答案
                int minCost = INF;
                // 最终状态是所有城市都至少访问了 1 次
                // 这样的状态 s，其三进制表示中没有 0
                for (int state = 1; state < maxState; state++) {
                    boolean allVisited = true;
                    for (int i = 1; i <= n; i++) {
                        // 检查第 i 个城市是否被访问过
                        if ((state / pow3[i - 1]) % 3 == 0) {
                            allVisited = false;
                            break;
                        }
                    }

                    if (allVisited) {
                        // 如果所有城市都访问过，那么这个状态的任何终点都是一个候选答案
                        for (int i = 1; i <= n; i++) {
                            minCost = Math.min(minCost, dp[state][i]);
                        }
                    }
                }

                if (minCost == INF) {
                    System.out.println(-1);
                } else {
                    System.out.println(minCost);
                }
            }
        }
    }
}
