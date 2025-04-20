package knowledge.algorithms.dp.backpack.zeroOne.problems;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 4/20/25 23:27
 */
public class HDU2602 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 测试用例数

        while (T-- > 0) {
            int N = sc.nextInt();  // 骨头数量
            int V = sc.nextInt();  // 背包容量
            int[] val = new int[N];  // 骨头价值
            int[] vol = new int[N];  // 骨头体积

            for (int i = 0; i < N; i++) val[i] = sc.nextInt();
            for (int i = 0; i < N; i++) vol[i] = sc.nextInt();

            int[] dp = new int[V + 1];

            for (int i = 0; i < N; i++) {
                for (int j = V; j >= vol[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - vol[i]] + val[i]);
                }
            }

            System.out.println(dp[V]);
        }
    }

    public static void main_2d(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            int V = sc.nextInt();
            int[] val = new int[N];
            int[] vol = new int[N];

            for (int i = 0; i < N; i++) val[i] = sc.nextInt();
            for (int i = 0; i < N; i++) vol[i] = sc.nextInt();

            int[][] dp = new int[N + 1][V + 1];

            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= V; j++) {
                    if (j >= vol[i - 1]) {
                        dp[i][j] = Math.max(dp[i - 1][j],
                                dp[i - 1][j - vol[i - 1]] + val[i - 1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            System.out.println(dp[N][V]);
        }
    }
}
