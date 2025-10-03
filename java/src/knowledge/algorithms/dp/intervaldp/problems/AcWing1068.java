package knowledge.algorithms.dp.intervaldp.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 10/2/25 21:15
 * <a href="https://www.acwing.com/problem/content/description/1070/"></a>
 */
public class AcWing1068 {

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] stones = new int[n + 1];

            // 读取石子数量
            for (int i = 1; i <= n; i++) {
                stones[i] = sc.nextInt();
            }

            // 前缀和数组
            int[] s = new int[2 * n + 1];
            for (int i = 1; i <= 2 * n; i++) {
                s[i] = s[i - 1] + stones[(i - 1) % n + 1];
            }

            // DP数组
            int[][] minDP = new int[2 * n + 1][2 * n + 1];
            int[][] maxDP = new int[2 * n + 1][2 * n + 1];

            // 初始化DP数组
            for (int i = 1; i <= 2 * n; i++) {
                Arrays.fill(minDP[i], Integer.MAX_VALUE);
                Arrays.fill(maxDP[i], Integer.MIN_VALUE);
                minDP[i][i] = 0;  // 单独一堆不需要合并，得分为0
                maxDP[i][i] = 0;
            }

            // 区间DP - 处理环形问题（i倒序，j正序的遍历方式）
            for (int i = 2 * n; i >= 1; i--) {           // i从大到小遍历
                for (int j = i + 1; j <= 2 * n; j++) {   // j从小到大遍历
                    // 只处理长度在[2, n]范围内的区间
                    if (j - i + 1 > n) continue;
                    // 初始化当前区间
                    minDP[i][j] = Integer.MAX_VALUE;
                    maxDP[i][j] = Integer.MIN_VALUE;
                    for (int k = i; k < j; k++) {        // 划分点
                        int cost = s[j] - s[i - 1];      // 合并代价
                        // 最小值
                        if (minDP[i][k] != Integer.MAX_VALUE && minDP[k + 1][j] != Integer.MAX_VALUE) {
                            minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k + 1][j] + cost);
                        }
                        // 最大值
                        if (maxDP[i][k] != Integer.MIN_VALUE && maxDP[k + 1][j] != Integer.MIN_VALUE) {
                            maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k + 1][j] + cost);
                        }
                    }
                }
            }
            // 在环形中找到最优解
            int minScore = Integer.MAX_VALUE;
            int maxScore = Integer.MIN_VALUE;

            for (int i = 1; i <= n; i++) {
                minScore = Math.min(minScore, minDP[i][i + n - 1]);
                maxScore = Math.max(maxScore, maxDP[i][i + n - 1]);
            }
            System.out.println(minScore);
            System.out.println(maxScore);
        }
    }
}
