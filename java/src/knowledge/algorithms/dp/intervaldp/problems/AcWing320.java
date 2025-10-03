package knowledge.algorithms.dp.intervaldp.problems;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 10/2/25 21:18
 */
public class AcWing320 {

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int[] w = new int[2 * n + 1];
            // 读取数据并复制成环形
            for (int i = 1; i <= n; i++) {
                w[i] = scanner.nextInt();
                w[i + n] = w[i];
            }
            int[][] f = new int[2 * n + 1][2 * n + 1];
            // 初始化DP数组为最小值
            for (int i = 0; i <= 2 * n; i++) {
                Arrays.fill(f[i], Integer.MIN_VALUE);
            }
            // 区间DP - i倒序，j正序
            for (int i = 2 * n; i >= 1; i--) {
                for (int j = i + 1; j <= 2 * n; j++) {
                    if (j - i == 1) {
                        // 相邻两个元素，得分为0
                        f[i][j] = 0;
                    } else {
                        for (int k = i + 1; k < j; k++) {
                            // 状态转移方程
                            f[i][j] = Math.max(f[i][j], f[i][k] + f[k][j] + w[i] * w[k] * w[j]);
                        }
                    }
                }
            }
            // 在环形中找到最大值
            int res = 0;
            for (int i = 1; i <= n; i++) {
                res = Math.max(res, f[i][i + n]);
            }
            System.out.println(res);
            scanner.close();
        }
    }
}
