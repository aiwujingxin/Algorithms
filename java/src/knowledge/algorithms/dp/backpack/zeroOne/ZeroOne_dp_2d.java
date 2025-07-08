package knowledge.algorithms.dp.backpack.zeroOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        int[][] cnt = new int[N + 1][V + 1];
        cnt[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int v = 0; v <= V; v++) {
                dp[i][v] = dp[i - 1][v];
                cnt[i][v] = cnt[i - 1][v];
                if (v >= C[i - 1]) {
                    dp[i][v] = Math.max(dp[i - 1][v], dp[i - 1][v - C[i - 1]] + W[i - 1]);
                    cnt[i][v] += cnt[i - 1][v - C[i - 1]];
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
        List<List<Integer>> result = new ArrayList<>();
        backtrack(N, V, C, W, dp, new ArrayList<>(), result);
        System.out.println("一种 选择的物品编号为:" + selected);
        System.out.println("All种 选择的物品编号为:" + result);
        System.out.println("方案的总数:" + cnt[N][V]);
        return dp[N][V];
    }


    // 回溯输出路径
    private static void backtrack(int i, int w, int[] weight, int[] value, int[][] dp, List<Integer> path, List<List<Integer>> result) {
        if (i == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 先尝试“选当前物品”，保证输出更接近贪心路径（必须满足容量够，并且选它是达到最大值的原因之一）
        if (w >= weight[i - 1] && dp[i][w] == dp[i - 1][w - weight[i - 1]] + value[i - 1]) {
            path.add(i - 1); // 添加物品编号
            backtrack(i - 1, w - weight[i - 1], weight, value, dp, path, result);
            path.remove(path.size() - 1); // 回溯
        }
        // 再尝试“不选当前物品”
        if (dp[i][w] == dp[i - 1][w]) {
            backtrack(i - 1, w, weight, value, dp, path, result);
        }
    }
}
