package knowledge.algorithms.dp.linerdp.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 3/27/25 00:57
 */
public class RodCutting {

    public static void cutRod(int[] prices, int n) {
        int[] f = new int[n + 1];  // 存储最大价值
        int[] g = new int[n + 1];  // 记录最优切割点
        f[0] = 0;                  // 长度为0的钢条价值为0
        for (int j = 1; j <= n; j++) {
            int maxVal = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                if (prices[i - 1] + f[j - i] > maxVal) {
                    maxVal = prices[i - 1] + f[j - i];
                    g[j] = i;
                }
            }
            f[j] = maxVal;
        }
        System.out.println("最大价值: " + f[n]);
        System.out.print("切割方案: ");
        int remaining = n;
        while (remaining > 0) {
            System.out.print(g[remaining] + " ");
            remaining -= g[remaining];
        }
    }

    public int cutRodMemo(int[] prices, int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MIN_VALUE);
        return dfs(prices, n, memo);
    }

    private int dfs(int[] prices, int n, int[] memo) {
        if (memo[n] >= 0) return memo[n];
        if (n == 0) return 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            maxVal = Math.max(maxVal, prices[i - 1] + dfs(prices, n - i, memo));
        }
        memo[n] = maxVal;
        return maxVal;
    }

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int n = 8;
        cutRod(prices, n);
        /* 输出:
           最大价值: 22
           切割方案: 2 6
        */
    }
}
