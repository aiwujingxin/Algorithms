package knowledge.algorithms.dp.compressdp.problems;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 16:48
 * @description 炮兵阵地
 */
public class Acwing292 {

    public static class Main {

        static final int N = 110;
        static final int M_STATE_SIZE = 1 << 10;

        // 全局变量
        static int n, m;
        static int[] g = new int[N]; // g[i]: 第 i 行的障碍物布局（'H'的位置）
        static int[] cnt = new int[M_STATE_SIZE]; // cnt[state]: 状态 state 中 1 的个数

        // f[i][a][b]: 前 i 行已摆好，第 i 行状态是 a，第 i-1 行状态是 b 的最大值
        // 使用滚动数组优化第一维
        static int[][][] f = new int[2][M_STATE_SIZE][M_STATE_SIZE];

        static List<Integer> state = new ArrayList<>(); // 存储所有合法的单行状态
        static List<Integer>[] head = new ArrayList[M_STATE_SIZE]; // head[a]: 能与状态 a 在相邻行共存的合法状态列表

        // 检查单行状态是否合法：任意三个连续的位置中最多只能有一个 1
        // 等价于：不能有两个 1 相邻，也不能有两个 1 中间隔一个 0
        public static boolean check(int s) {
            // !(state & state >> 1) 检查没有相邻的1
            // !(state & state >> 2) 检查没有相隔一位的1
            return !((s & (s >> 1)) != 0 || (s & (s >> 2)) != 0);
        }


        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(reader.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // 读取地图，构建障碍物掩码 g[i]
            for (int i = 1; i <= n; i++) {
                String line = reader.readLine();
                for (int j = 0; j < m; j++) {
                    if (line.charAt(j) == 'H') {
                        g[i] += (1 << j);
                    }
                }
            }

            // 1. 预处理：筛选出所有合法的单行状态
            for (int i = 0; i < (1 << m); i++) {
                if (check(i)) {
                    state.add(i);
                    cnt[i] = Integer.bitCount(i);
                }
            }

            // 初始化 head 数组
            for (int i = 0; i < (1 << m); i++) {
                head[i] = new ArrayList<>();
            }

            // 2. 预处理：枚举出任意两个合法状态 a 和 b，如果它们不冲突，则可以作为相邻行的布局
            for (int a : state) {
                for (int b : state) {
                    if ((a & b) == 0) {
                        head[a].add(b);
                    }
                }
            }

            // 3. 动态规划
            // 循环 i 从 1 到 n+2，是为了处理边界情况，相当于在棋盘上下各加了两行空行作为哨兵
            for (int i = 1; i <= n + 2; i++) {
                // 在计算第 i 层之前，需要清空 f[i & 1] 的数据
                // C++ 中全局变量默认为0，Java中需要手动处理。
                // 但因为我们总是取 max，且初始值都为0，所以不清空也恰好没问题。
                // 如果是求和，则必须清空。为严谨，可以加上清空逻辑。
                // for(int[] row : f[i & 1]) Arrays.fill(row, 0);

                for (int a : state) { // 枚举第 i 行的状态 a
                    // 剪枝：当前行的布局 a 不能与该行的障碍物 g[i] 有重叠
                    if ((g[i] & a) != 0) continue;

                    for (int b : head[a]) { // 枚举第 i-1 行的状态 b (必须与 a 不冲突)
                        for (int c : head[b]) { // 枚举第 i-2 行的状态 c (必须与 b 不冲突)

                            // 剪枝：三行状态之间不能有任何冲突
                            // a 和 b 的冲突已由 head[a] 保证。
                            // b 和 c 的冲突已由 head[b] 保证。
                            // 只需额外检查 a 和 c 是否冲突。
                            if ((a & c) != 0) continue;

                            // 状态转移方程
                            // f[i][a][b] = max(f[i][a][b], f[i-1][b][c] + cnt[a])
                            int currentVal = f[(i - 1) & 1][b][c] + cnt[a];
                            f[i & 1][a][b] = Math.max(f[i & 1][a][b], currentVal);
                        }
                    }
                }
            }

            // 最终答案在 f[(n+2) & 1][0][0]
            // 这表示在处理完所有行（包括哨兵行）后，最后两行状态都为0（不放任何炮兵）时的最大值
            System.out.println(f[(n + 2) & 1][0][0]);
        }
    }
}
