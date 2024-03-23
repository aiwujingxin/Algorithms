package knowledge.algorithms.dp.backpack.twocost;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 16:37
 * @description 二维费用背包
 */
public class TwoCost_dp_3d implements TwoCostPack {

    public int backPack(int N, int V, int W, int[] volumes, int[] weights, int[] values) {
        List<Integer> result = new ArrayList<>();
        int[][][] dp = new int[N + 1][W + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= W; j++) {
                for (int k = 0; k <= V; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= weights[i - 1] && k >= volumes[i - 1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - weights[i - 1]][k - volumes[i - 1]] + values[i - 1]);
                    }
                }
            }
        }
        int volume = V;
        int weight = W;
        for (int i = N; i >= 1; i--) {
            //dp[i][weight][volume] == dp[i - 1][weight][volume] + values[i - 1] 这样也行
            if (dp[i][weight][volume] != dp[i - 1][weight][volume]) {
                result.add(i - 1);
                volume -= volumes[i - 1];
                weight -= weights[i - 1];
            }
        }
        for (Integer index : result) {
            System.out.println("选择物品 " + index + ",它的价值" + values[index] + ".");
        }
        return dp[N][W][V];
    }
}
