package knowledge.algorithms.dp.compressdp.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 16:55
 * @description 骑士
 */
public class Acwing1064 {

    public static class Main {

        // N: 最大行数 (题目中是 n x n，但 DP 循环到 n+1，所以数组大小要足够)
        private static final int N = 12;
        // K: 最多国王数
        private static final int K = 110;
        // M: 状态总数，1 << 10 表示 2^10 = 1024
        private static final int M = 1 << 10;

        // n: 棋盘的维度, m: 要放置的国王总数
        private static int n;

        // state: 存储所有合法的单行状态 (二进制表示)
        private static final List<Integer> state = new ArrayList<>();

        // count: 存储每个合法状态包含的国王数量 (1的数量)
        // 数组索引是状态的二进制值
        private static final int[] count = new int[M];

        // head: 存储状态转移关系。head[i] 是一个列表，
        // 包含了所有可以合法地放在 state.get(i) 的上一行的状态的索引。
        private static final List<Integer>[] head = new ArrayList[M];

        // DP 数组: f[i][j][k]
        // i: 当前处理到第 i 行
        // j: 已经放置了 j 个国王
        // k: 第 i 行的状态在 state 列表中的索引
        private static long[][][] f = new long[N][K][M];

        /**
         * 检查单个行状态是否合法。
         * 合法意味着没有两个国王是相邻的。
         *
         * @param s 状态的二进制表示
         * @return 如果合法返回 true，否则返回 false
         */
        private static boolean check(int s) {
            // 遍历每一位，检查它和它的下一位是否同时为1
            for (int i = 0; i < n; i++) {
                if ((s >> i & 1) == 1 && (s >> (i + 1) & 1) == 1) {
                    return false;
                }
            }
            return true;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            int m = scanner.nextInt();
            scanner.close();

            // 1. 预处理：找出所有合法的单行状态
            for (int i = 0; i < (1 << n); i++) {
                if (check(i)) {
                    state.add(i);
                    count[i] = Integer.bitCount(i);
                }
            }

            // 初始化 head 数组中的每个列表
            for (int i = 0; i < state.size(); i++) {
                head[i] = new ArrayList<>();
            }

            // 2. 预处理：构建状态转移图
            // 遍历所有合法的状态对 (a, b)
            for (int i = 0; i < state.size(); i++) {
                for (int j = 0; j < state.size(); j++) {
                    int a = state.get(i); // 当前行状态
                    int b = state.get(j); // 上一行状态

                    // 检查兼容性：
                    // 1. (a & b) == 0: 同一列不能都有国王 (上下不冲突)
                    // 2. check(a | b): a和b合并后，不能有相邻的1 (斜向不冲突)
                    if ((a & b) == 0 && check(a | b)) {
                        // 如果兼容，则从状态 b 可以转移到状态 a
                        // head[i] 存储的是可以转移到状态 i 的前驱状态的索引
                        head[i].add(j);
                    }
                }
            }

            // 3. 动态规划
            // 初始化：f[0][0][0] = 1
            // C++的 f[0][0][0] 对应 Java 的 f[0][0][state.indexOf(0)]
            // state.get(0) 恰好是0，所以索引是0
            f[0][0][0] = 1;

            // i: 当前行号 (从1到n+1)
            for (int i = 1; i <= n + 1; i++) {
                // j: 当前已用国王数 (从0到m)
                for (int j = 0; j <= m; j++) {
                    // aIdx: 当前行状态在 state 列表中的索引
                    for (int aIdx = 0; aIdx < state.size(); aIdx++) {
                        // bIdx: 上一行状态在 state 列表中的索引
                        for (int bIdx : head[aIdx]) {
                            int currentState = state.get(aIdx);
                            int kingsInCurrentState = count[currentState];

                            // 如果当前国王总数 j 大于等于当前行所需国王数
                            if (j >= kingsInCurrentState) {
                                // 状态转移
                                f[i][j][aIdx] += f[i - 1][j - kingsInCurrentState][bIdx];
                            }
                        }
                    }
                }
            }

            // 4. 输出结果
            // 结果是 f[n+1][m][0]，表示处理完 n+1 行 (虚拟的)，总共用了 m 个国王，
            // 且第 n+1 行的状态为0 (即不放任何国王) 时的方案数。
            // 状态0在state列表中的索引是0。
            System.out.println(f[n + 1][m][0]);
        }
    }
}
