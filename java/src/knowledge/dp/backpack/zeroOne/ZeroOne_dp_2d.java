package knowledge.dp.backpack.zeroOne;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/29 23:20
 * @link <a href="https://www.acwing.com/problem/content/11/">最优选法的方案数</a>
 * @link <a href="https://www.acwing.com/problem/content/12/">背包问题求具体方案</a>
 */

public class ZeroOne_dp_2d implements ZeroOnePack {

    @Override
    public int backPack(int[] C, int[] W, int V) {
        int N = C.length;
        int[][] dp = new int[N + 1][V + 1];
        int[][] f = new int[N + 1][V + 1];
        f[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int v = 0; v <= V; v++) {
                dp[i][v] = dp[i - 1][v];
                f[i][v] = f[i - 1][v];
                if (v >= C[i - 1]) {
                    dp[i][v] = Math.max(dp[i - 1][v], dp[i - 1][v - C[i - 1]] + W[i - 1]);
                    f[i][v] += f[i - 1][v - C[i - 1]];
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        int i = N;
        int v = V;
        while (i > 0) {
            if (v - C[i - 1] >= 0 && dp[i][v] == dp[i - 1][v - C[i - 1]] + W[i - 1]) {
                result.add(i - 1);
                v -= C[i - 1];
            }
            i--;
        }
        System.out.println("选择的物品编号为:" + result);
        System.out.println("方案的总数:" + f[N][V]);
        return dp[N][V];
    }
}
