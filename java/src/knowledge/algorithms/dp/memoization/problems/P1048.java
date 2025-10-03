package knowledge.algorithms.dp.memoization.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 10/2/25 20:57
 * <a href="https://www.luogu.com.cn/problem/P1048">采药</a>
 */
public class P1048 {

    public class DFS {
        static int n, t;
        static int[] tcost, mget;
        static int[][] mem;
        static final int INF = 0x3f3f3f3f;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            t = scanner.nextInt();
            n = scanner.nextInt();

            tcost = new int[n + 1];
            mget = new int[n + 1];
            mem = new int[n + 2][t + 1];

            // 初始化记忆化数组为-1
            for (int i = 0; i <= n + 1; i++) {
                Arrays.fill(mem[i], -1);
            }

            for (int i = 1; i <= n; i++) {
                tcost[i] = scanner.nextInt();
                mget[i] = scanner.nextInt();
            }

            System.out.println(dfs(1, t));
            scanner.close();
        }

        static int dfs(int pos, int tleft) {
            // 已经访问过的状态，直接返回之前记录的值
            if (mem[pos][tleft] != -1) {
                return mem[pos][tleft];
            }

            // 边界条件：所有物品都考虑完毕
            if (pos == n + 1) {
                return mem[pos][tleft] = 0;
            }

            int dfs1, dfs2 = -INF;

            // 不选择当前物品
            dfs1 = dfs(pos + 1, tleft);

            // 如果剩余时间足够，选择当前物品
            if (tleft >= tcost[pos]) {
                dfs2 = dfs(pos + 1, tleft - tcost[pos]) + mget[pos];
            }

            // 记录并返回最优解
            return mem[pos][tleft] = Math.max(dfs1, dfs2);
        }
    }

    public class DPTable {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int T = scanner.nextInt();  // 总时间
            int M = scanner.nextInt();  // 草药数目

            int[] time = new int[M + 1];    // 采摘时间
            int[] value = new int[M + 1];   // 草药价值
            int[][] dp = new int[M + 1][T + 1];  // DP数组

            for (int i = 1; i <= M; i++) {
                time[i] = scanner.nextInt();
                value[i] = scanner.nextInt();
            }

            // 动态规划
            for (int i = 1; i <= M; i++) {
                for (int j = 0; j <= T; j++) {
                    // 不选第i株草药
                    dp[i][j] = dp[i - 1][j];
                    // 如果时间足够，考虑选第i株草药
                    if (j >= time[i]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - time[i]] + value[i]);
                    }
                }
            }

            System.out.println(dp[M][T]);
            scanner.close();
        }
    }


    public class DPOpt {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int T = scanner.nextInt();  // 总时间
            int M = scanner.nextInt();  // 草药数目
            int[] time = new int[M + 1];    // 采摘时间
            int[] value = new int[M + 1];   // 草药价值
            int[] dp = new int[T + 1];      // DP数组
            for (int i = 1; i <= M; i++) {
                time[i] = scanner.nextInt();
                value[i] = scanner.nextInt();
            }
            // 动态规划 - 空间优化版本
            for (int i = 1; i <= M; i++) {
                // 逆序遍历，确保每个草药只被采摘一次
                for (int j = T; j >= time[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - time[i]] + value[i]);
                }
            }
            System.out.println(dp[T]);
            scanner.close();
        }
    }
}
