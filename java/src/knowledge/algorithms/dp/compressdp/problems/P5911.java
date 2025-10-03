package knowledge.algorithms.dp.compressdp.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author wujingxinit@outlook.com
 * @date 9/26/25 14:40
 * @description <a href="https://www.luogu.com.cn/problem/P5911">PRZ</a>
 */
public class P5911 {

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(reader.readLine());
            // 1. 输入数据
            int W = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int[] weights = new int[n];
            int[] times = new int[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(reader.readLine());
                // 题目格式是先 t 后 w
                times[i] = Integer.parseInt(st.nextToken());
                weights[i] = Integer.parseInt(st.nextToken());
            }
            // 状态总数，即 2^n
            int totalStates = 1 << n;
            // 2. 预处理：计算所有子集（分组）的总重量和过桥时间
            long[] groupWeight = new long[totalStates];
            int[] groupTime = new int[totalStates];
            // 遍历所有可能的子集 s (从 1 到 2^n - 1)
            for (int s = 1; s < totalStates; s++) {
                int maxTimeInGroup = 0;
                long totalWeightInGroup = 0;
                // 遍历所有人，判断是否在当前子集 s 中
                for (int i = 0; i < n; i++) {
                    // 使用位运算检查第 i 个人是否在集合 s 中
                    if (((s >> i) & 1) == 1) {
                        totalWeightInGroup += weights[i];
                        maxTimeInGroup = Math.max(maxTimeInGroup, times[i]);
                    }
                }
                groupWeight[s] = totalWeightInGroup;
                groupTime[s] = maxTimeInGroup;
            }
            // 3. 动态规划
            // dp[S] 表示让状态 S 所代表的人群全部过桥所需的最短时间
            long[] dp = new long[totalStates];
            // 初始化 dp 数组，除了 dp[0]，其他都设为无穷大
            // 使用一个很大的值代表无穷大，防止加法溢出
            Arrays.fill(dp, Long.MAX_VALUE / 2);
            // 初始状态：没有人过桥，时间为 0
            dp[0] = 0;
            // 外层循环：遍历所有状态 S (从 1 到 2^n - 1)
            for (int S = 1; S < totalStates; S++) {
                // 内层循环：遍历 S 的所有子集 s
                // s = (s - 1) & S 是一个高效遍历子集的技巧
                for (int s = S; s > 0; s = (s - 1) & S) {
                    // 检查子集 s 是否可以作为一组过桥（重量不超过 W）
                    if (groupWeight[s] <= W) {
                        // S ^ s 表示 S 中排除了 s 之后剩下的状态
                        // 这是一个已经计算过的子问题 dp[S ^ s]
                        long previousStateTime = dp[S ^ s];
                        int thisGroupTime = groupTime[s];
                        // 状态转移方程：
                        // dp[S] 的当前值 vs (完成前面状态的时间 + 当前这组的时间)
                        dp[S] = Math.min(dp[S], previousStateTime + thisGroupTime);
                    }
                }
            }
            // 4. 输出结果
            // dp[totalStates - 1] 对应的状态是所有人都过桥了 (二进制表示为 n 个 1)
            long result = dp[totalStates - 1];
            System.out.println(result);
        }
    }
}
