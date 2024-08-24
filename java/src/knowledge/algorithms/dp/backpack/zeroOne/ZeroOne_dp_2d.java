package knowledge.algorithms.dp.backpack.zeroOne;

import java.util.ArrayList;
import java.util.List;

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
        int[][] g = new int[N + 1][V + 1];
        g[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int v = 0; v <= V; v++) {
                dp[i][v] = dp[i - 1][v];
                g[i][v] = g[i - 1][v];
                if (v >= C[i - 1]) {
                    dp[i][v] = Math.max(dp[i - 1][v], dp[i - 1][v - C[i - 1]] + W[i - 1]);
                    g[i][v] += g[i - 1][v - C[i - 1]];
                }
            }
        }
        List<Integer> selected = new ArrayList<>();
        int v = V;
        for (int i = N; i > 0; i--) {
            if (v - C[i - 1] >= 0 && dp[i][v] == dp[i - 1][v - C[i - 1]] + W[i - 1]) {
                selected.add(i - 1);
                v -= C[i - 1];
            }
        }
        System.out.println("选择的物品编号为:" + selected);
        System.out.println("方案的总数:" + g[N][V]);
        return dp[N][V];
    }
}
