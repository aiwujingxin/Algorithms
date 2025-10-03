package knowledge.algorithms.dp.compressdp.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/27/25 22:08
 * @description 有 n 个城市，城市之间的距离已知。一个旅行商要从起点城市出发，访问每个城市一次，并回到起点，要求总路程最短。
 * <a href="https://www.luogu.com.cn/problem/P1171"></a>
 * Held-Karp 的 TSP 用了 集合 + 最后一个点 作为状态：能覆盖 所有排列的最优路径
 * <正序 vs 逆序>
 * 正序（小→大）状态表示“已访问的集合 + 最后停留的城市”
 * Pull：从上一步集合拉到当前集合 → 使用 s ^ {v}
 * Push：从当前集合推到下一集合 → 使用 s | {v}
 * 逆序（大→小）状态表示“当前城市 + 已访问集合 + 剩余城市”
 * Pull：从未来状态拉回来 → 使用 s | {u}
 * Push：从当前状态推到子集合 → 使用 s ^ {v}
 * <Pull VS Push>
 * Pull = “我现在想得到这个状态的最优值，从哪里拉来？”
 * Push = “我现在这个状态的值，能推送给哪些下一状态？”
 * <效率>
 * 就逆序Push超时
 * `Pull` 模式的实现天然地将“计算一个状态所需的所有信息”聚合在一起，使得每个状态只被计算一次。
 * `Push` 模式，将一个状态的计算过程分散开来，导致了严重的性能问题。
 * 核心结论：无论是 Push 还是 Pull，无论是正向还是逆向，一个高效的 DP 实现必须保证当计算一个状态时，它所依赖的所有其他状态都已经是计算完毕的最终值。
 */
public class P1171 {

    public class Main {
        static int n;
        static int[][] dist;
        static int[][] dp;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            dist = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = sc.nextInt();
                }
            }
            System.out.println(tspIterativePull());
            sc.close();
        }

        // 记忆化搜索 超时：递归开销
        public static int tspDfs() {
            dp = new int[1 << n][n];
            for (int[] row : dp) Arrays.fill(row, -1);
            // s=1 表示只访问过起点0
            // v：表示当前所在的城市
            return f(1, 0);
        }

        public static int f(int s, int v) {
            if (s == (1 << n) - 1) return dist[v][0]; // 所有村庄都访问过，回到起点
            if (dp[s][v] != -1) return dp[s][v];
            int ans = Integer.MAX_VALUE / 2;
            for (int u = 0; u < n; u++) {
                if ((s & (1 << u)) == 0) {            // u 还没访问过, u 成为新的当前位置
                    ans = Math.min(ans, f(s | (1 << u), u) + dist[v][u]);
                }
            }
            dp[s][v] = ans;
            return ans;
        }

        // ==== 正序Pull  ==== ： 从小集合（只包含 0）开始，逐渐扩展到大集合（包含所有点）。
        public static int tspIterativePull() {
            // dp[s][v] = 从起点 0 出发，走过集合 s 中所有点，并且当前停在 v 的最小花费。
            int[][] dp = new int[1 << n][n];
            for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE / 2);
            dp[1][0] = 0;
            for (int s = 1; s < (1 << n); s++) {           // 阶段 枚举顺序：s = 1 .. (1<<n)-1，不断“加点”。
                for (int v = 0; v < n; v++) {              // 状态
                    // v不在集合里
                    if ((s & (1 << v)) == 0) continue;
                    for (int u = 0; u < n; u++) {          // 决策
                        if (u == v) continue;
                        // u不在集合里
                        if ((s & (1 << u)) == 0) continue;
                        // 当前状态 dp[s][v] 是通过 从所有可能的上一步状态转移过来 计算得到的。
                        //子问题 dp[s ^ {v}][u] 已经隐含了所有可能顺序，并记录最优值。
                        dp[s][v] = Math.min(dp[s][v], dp[s ^ (1 << v)][u] + dist[u][v]);
                    }
                }
            }
            // 回到起点0
            int ans = Integer.MAX_VALUE;
            for (int v = 1; v < n; v++) {
                ans = Math.min(ans, dp[(1 << n) - 1][v] + dist[v][0]);
            }
            return ans;
        }

        // ==== 正序Push ==== 的核心思想是：固定来源状态，把值“推送”给下一个可能状态。
        public static int tspIterativePush() {
            int[][] dp = new int[1 << n][n];
            for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 2);
            dp[1][0] = 0; // 只访问起点 0
            for (int s = 1; s < 1 << n; s++) {
                for (int u = 0; u < n; u++) {
                    if ((s & (1 << u)) == 0) continue; // u 不在集合 s 中，跳过
                    if (dp[s][u] == Integer.MAX_VALUE / 2) continue; // 不可达状态
                    // 枚举下一个城市 v
                    for (int v = 0; v < n; v++) {
                        if ((s & (1 << v)) != 0) continue; // v 已访问过，跳过
                        int next = s | (1 << v);
                        dp[next][v] = Math.min(dp[next][v], dp[s][u] + dist[u][v]);
                    }
                }
            }
            // 回到起点 0
            int ans = Integer.MAX_VALUE;
            for (int v = 1; v < n; v++) {
                ans = Math.min(ans, dp[(1 << n) - 1][v] + dist[v][0]);
            }
            return ans;
        }

        // ==== 逆序Pull  ==== 从大到小 从全集开始，逐步往回退（删点）
        public static int tspReversePull() {
            // dp[s][v] = 当前在顶点 `v`，已经访问过的顶点集合是 `s`，接下来还需要访问所有 `s` 之外的顶点，并最终回到起点 `0` 的最小花费。
            //- `s`: 一个二进制数，表示已经访问过的顶点集合。如果第 `i` 位是 `1`，代表顶点 `i` 已经被访问过了。
            //- `v`: 当前所在的顶点。`v` 必须是 `s` 集合中的一员，因为我们不可能凭空出现在一个还没访问过的点上。
            int[][] dp = new int[1 << n][n];
            for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 2);
            // 初始状态：所有点都访问过，停在 v，回到起点的代价
            for (int v = 0; v < n; v++) {
                dp[(1 << n) - 1][v] = dist[v][0];
            }
            for (int s = (1 << n) - 2; s >= 1; s--) {      // 枚举顺序：s = (1<<n)-2 .. 1，不断“减点”。
                for (int v = 0; v < n; v++) {
                    if ((s & (1 << v)) == 0) continue;     // v 不在集合里
                    for (int u = 0; u < n; u++) {
                        if ((s & (1 << u)) != 0) continue; // u 已访问过 跳过
                        // 当前状态 dp[s][v] 依赖 更大的集合状态 dp[s | {u}][u]
                        // 从 v 出发，去访问还没访问过的 u，再加上后面从 u 开始完成整个旅程的代价。
                        dp[s][v] = Math.min(dp[s][v], dp[s | (1 << u)][u] + dist[v][u]);
                    }
                }
            }
            return dp[1][0];
        }

        // ==== 逆序Push  ==== 高于 `O(n^2 * 2^n)`
        public static int tspReversePush() {
            int[][] dp = new int[1 << n][n];
            for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 2);
            for (int v = 0; v < n; v++) {
                dp[(1 << n) - 1][v] = dist[v][0];
            }
            for (int s = (1 << n) - 1; s >= 1; s--) {
                for (int u = 0; u < n; u++) {
                    if ((s & (1 << u)) == 0) continue;      // u 不在集合里，跳过
                    for (int v = 0; v < n; v++) {
                        if (v == u) continue;
                        if ((s & (1 << v)) == 0) continue;  // v 不在集合里，跳过
                        int next = s ^ (1 << v);            // 从 s 推到 s ^ {v}
                        dp[next][u] = Math.min(dp[next][u], dp[s][v] + dist[u][v]);
                    }
                }
            }
            return dp[1][0];
        }

        // === tspWithPath ===
        public static Result tspWithPath() {
            final int INF = (int) 1e9;
            int N = 1 << n;
            int[][] dp = new int[N][n];
            int[][] parent = new int[N][n]; // 记录前一个节点
            for (int[] row : dp) Arrays.fill(row, INF);
            for (int[] row : parent) Arrays.fill(row, -1);
            dp[1][0] = 0; // 从0开始
            for (int s = 1; s < N; s++) {
                for (int u = 0; u < n; u++) {
                    if ((s & (1 << u)) == 0) continue;
                    if (dp[s][u] == INF) continue;
                    for (int v = 0; v < n; v++) {
                        if ((s & (1 << v)) != 0) continue;
                        int ns = s | (1 << v);
                        if (dp[ns][v] > dp[s][u] + dist[u][v]) {
                            dp[ns][v] = dp[s][u] + dist[u][v];
                            parent[ns][v] = u; // 从 u 来到 v
                        }
                    }
                }
            }
            int minCost = INF;
            int last = -1;
            int full = N - 1;
            for (int v = 1; v < n; v++) {
                if (dp[full][v] + dist[v][0] < minCost) {
                    minCost = dp[full][v] + dist[v][0];
                    last = v;
                }
            }
            // 回溯路径
            List<Integer> path = new ArrayList<>();
            int mask = full;
            int curr = last;
            while (curr != -1) {
                path.add(curr);
                int prev = parent[mask][curr];
                mask ^= (1 << curr);
                curr = prev;
            }
            path.add(0); // 加起点
            Collections.reverse(path);
            return new Result(minCost, path);
        }

        static class Result {
            int minCost;
            List<Integer> path;

            Result(int c, List<Integer> p) {
                minCost = c;
                path = p;
            }
        }
    }
}
