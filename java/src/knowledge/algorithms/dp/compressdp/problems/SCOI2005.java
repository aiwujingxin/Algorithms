package knowledge.algorithms.dp.compressdp.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 9/26/25 14:23
 * @link <a href="https://www.luogu.com.cn/problem/P1896"></a>
 */
public class SCOI2005 {

    public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            scanner.close();
            // dp[i][j][k] 表示到第 i 行（从1开始），已经放置了 j 个国王，
            // 且第 i 行的布局状态为 s (s是validStates的索引)时的方案数。
            // 为了方便理解，我们让第一维表示行数，从 1 到 N。
            // 第二维是状态的索引，第三维是国王总数。
            // 1. 预处理：找出所有合法的单行状态
            List<Integer> validStates = new ArrayList<>();
            int[] sta = new int[1 << N]; // 存储每个状态的国王数量
            for (int state = 0; state < (1 << N); state++) {
                // 检查行内是否有相邻的国王
                // (state & (state << 1)) == 0 保证了没有两个1是相邻的
                if ((state & (state << 1)) == 0) {
                    validStates.add(state);
                    // 计算这个状态有多少个国王（二进制中1的个数）
                    sta[state] = Integer.bitCount(state);
                }
            }
            // dp[i][state_idx][count]
            // i: 当前行号 (1 to N)
            // state_idx: validStates 列表中的索引
            // count: 到当前行为止放置的国王总数
            long[][][] dp = new long[N + 1][validStates.size()][K + 1];
            // 2. 初始化 DP 数组 (处理第一行)
            for (int i = 0; i < validStates.size(); i++) {
                int state = validStates.get(i);
                int count = sta[state];
                if (count <= K) {
                    dp[1][i][count] = 1;
                }
            }
            // 3. 状态转移 (从第 2 行到第 N 行)
            for (int i = 2; i <= N; i++) {                          // 阶段 当前行
                for (int j = 0; j < validStates.size(); j++) {      // 状态 当前行的状态
                    int currentState = validStates.get(j);
                    for (int x = 0; x < validStates.size(); x++) { // 上一行的状态
                        int prevState = validStates.get(x);
                        // 检查两行是否冲突
                        // 1. 垂直不冲突: (currentState & prevState) == 0
                        // 2. 左上-右下对角线不冲突: (currentState & (prevState << 1)) == 0
                        // 3. 右上-左下对角线不冲突: (currentState & (prevState >> 1)) == 0
                        if ((currentState & prevState) == 0 && (currentState & (prevState << 1)) == 0 && (currentState & (prevState >> 1)) == 0) {
                            // 如果不冲突，则可以从上一行的状态转移过来
                            for (int l = sta[currentState]; l <= K; l++) {
                                dp[i][j][l] += dp[i - 1][x][l - sta[currentState]];
                            }
                        }
                    }
                }
            }
            // 4. 计算最终结果
            // 将最后一行（第 N 行）所有状态下，国王总数为 K 的方案数相加
            long totalSolutions = 0;
            for (int i = 0; i < validStates.size(); i++) {
                totalSolutions += dp[N][i][K];
            }
            System.out.println(totalSolutions);
        }
    }
}
