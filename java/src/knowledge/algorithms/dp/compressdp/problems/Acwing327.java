package knowledge.algorithms.dp.compressdp.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author wujingxinit@outlook.com
 * @date 9/24/25 16:52
 * @description 玉米田
 */
public class Acwing327 {

    public static class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            final int MOD = 100_000_000;

            // 1. 预处理农场土地布局
            int[] layout = new int[M + 1];
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(reader.readLine());
                int rowLayout = 0;
                for (int j = 0; j < N; j++) {
                    rowLayout <<= 1;
                    rowLayout |= Integer.parseInt(st.nextToken());
                }
                layout[i] = rowLayout;
            }

            // 2. 预处理所有“单行内合法”的状态 一个状态是合法的，当且仅当它的二进制表示中没有相邻的 '1'
            List<Integer> validStates = new ArrayList<>();
            for (int state = 0; state < (1 << N); state++) {
                // 检查是否有水平相邻的玉米
                if ((state & (state << 1)) == 0) {
                    validStates.add(state);
                }
            }

            // dp[i][state]: 考虑到第 i 行，且第 i 行的种植状态为 state 时的总方案数
            int[][] dp = new int[M + 1][1 << N];

            // 初始化：第 0 行什么都不种，方案数为 1
            dp[0][0] = 1;

            // 3. 状态转移 (使用优化后的循环)
            for (int i = 1; i <= M; i++) { // 遍历每一行
                for (int currentState : validStates) {  // 只遍历那些本身水平合法的状态
                    // 检查当前状态是否能在第 i 行的土地上种植
                    if ((currentState & layout[i]) == currentState) {
                        // 遍历上一行的所有水平合法状态
                        for (int prevState : validStates) {
                            // 检查与上一行状态是否垂直兼容
                            if ((currentState & prevState) == 0) {
                                dp[i][currentState] = (dp[i][currentState] + dp[i - 1][prevState]) % MOD;
                            }
                        }
                    }
                }
            }
            // 4. 计算最终结果
            // 累加最后一行的所有合法状态的方案数
            long totalWays = 0;
            for (int state : validStates) {
                totalWays = (totalWays + dp[M][state]) % MOD;
            }

            System.out.println(totalWays);
        }
    }
}
