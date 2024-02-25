package knowledge.dp.backpack.lintcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 18:23
 * @description 多重背包
 * @link <a href="https://github.com/cherryljr/LintCode/blob/master/Backpack%20VIII.java">...</a>
 * 给一些不同价值和数量的硬币。找出这些硬币可以组合在1 ~ n范围内的值
 */
public class BackpackVIII {

    public int backPack(int m, int[] value, int[] amount) {
        int n = value.length;
        boolean[][] dp = new boolean[n][m + 1];
        // Initialize
        for (int i = 0; i <= amount[0]; i++) {
            if (i * value[0] <= m) {
                dp[0][i * value[0]] = true;
            }
        }

        // Function
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= amount[i]; k++) {
                    if (j >= k * value[i]) {
                        dp[i][j] |= dp[i - 1][j - k * value[i]];
                    } else {
                        // 如果当前价值超过了总价值 j,那么后面就没有继续计算的必要了
                        break;
                    }
                }
            }
        }

        // Answer
        int rst = 0;
        for (int i = 0; i <= m; i++) {
            if (dp[n - 1][i]) {
                rst++;
            }
        }
        return rst - 1;
    }
}
