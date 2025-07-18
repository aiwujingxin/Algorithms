package knowledge.algorithms.dp.backpack.complete.problems;

import java.util.Scanner;

/**
 * @author wujingxinit@outlook.com
 * @date 4/20/25 23:12
 * @description <a href="https://acm.hdu.edu.cn/showproblem.php?pid=2069"></a>
 * 求在不限数量使用的硬币（币值为 1, 5, 10, 25, 50）构成某个金额 N 的不同方案数。
 */
public class HDU2069 {

    class Main {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] coins = {1, 5, 10, 25, 50};
            int maxAmount = 250;
            int maxCoins = 100;
            // dp[j][k]：金额j使用k个硬币的方法数
            int[][] dp = new int[maxAmount + 1][maxCoins + 1];
            dp[0][0] = 1;
            for (int coin : coins) {
                for (int j = coin; j <= maxAmount; j++) {
                    for (int k = 1; k <= maxCoins; k++) {
                        dp[j][k] += dp[j - coin][k - 1];
                    }
                }
            }
            int[] ways = new int[maxAmount + 1];
            for (int j = 0; j <= maxAmount; j++) {
                for (int k = 0; k <= maxCoins; k++) {
                    ways[j] += dp[j][k];
                }
            }
            while (sc.hasNext()) {
                int N = sc.nextInt();
                System.out.println(ways[N]);
            }
        }
    }

    public static void main_3d(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] coins = {1, 5, 10, 25, 50};
        int maxAmount = 250;
        int maxCoins = 100;

        // 初始化DP数组
        int[][][] dp = new int[coins.length + 1][maxAmount + 1][maxCoins + 1];
        dp[0][0][0] = 1;

        for (int i = 1; i <= coins.length; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= maxAmount; j++) {
                for (int k = 0; k <= maxCoins; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];  // 不使用当前硬币
                    if (j >= coin && k >= 1) {
                        dp[i][j][k] += dp[i][j - coin][k - 1];  // 使用一个当前硬币
                    }
                }
            }
        }

        // 预处理所有可能的结果
        int[] result = new int[maxAmount + 1];
        for (int j = 0; j <= maxAmount; j++) {
            for (int k = 0; k <= maxCoins; k++) {
                result[j] += dp[coins.length][j][k];
            }
        }

        // 处理输入输出
        while (sc.hasNext()) {
            int N = sc.nextInt();
            System.out.println(result[N]);
        }
    }
}
