package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/11/26 22:08
 */
public class LeetCode279_dp_2d {

    int INF = 0x3f3f3f3f;

    public int numSquares(int n) {
        // 预处理出所有可能用到的「完全平方数」
        List<Integer> list = new ArrayList<>();
        int t = 1;
        while (t * t <= n) {
            list.add(t * t);
            t++;
        }
        // f[i][j] 代表考虑前 i 个物品，凑出 j 所使用到的最小元素个数
        int m = list.size();
        int[][] f = new int[m + 1][n + 1];

        // 当没有任何数时，除了 f[0][0] 为 0（花费 0 个数值凑出 0），其他均为无效值
        Arrays.fill(f[0], INF);
        f[0][0] = 0;

        // 处理剩余数的情况
        for (int i = 1; i <= m; i++) {
            int x = list.get(i - 1);
            for (int j = 0; j <= n; j++) {
                // 对于不选第 i 个数的情况
                f[i][j] = f[i - 1][j];
                // 对于选 k 次第 i 个数的情况
                for (int k = 1; k * x <= j; k++) {
                    // 能够选择 k 个 x 的前提是剩余的数字 j - k * x 也能被凑出
                    if (f[i - 1][j - k * x] != INF) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - k * x] + k);
                    }
                }
            }
        }
        return f[m][n];
    }
}
