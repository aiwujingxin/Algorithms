package basicKnowledge.algorithm.dynamicProgramming.knapsack.lintcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/8 18:23
 * @description 多重背包
 */
/*
 * 给一些不同价值和数量的硬币。找出这些硬币可以组合在1 ~ n范围内的值
 *
 * Approach: Multiple Backpack
 * <p>
 * 该题属于多重背包问题。
 * dp[i][j]表示：在前 i 个元素中，取得价值为 j 的方案是否成立
 * 因此 dp[i][j] |= dp[i - 1][j - k * value[i]] (j >= k * value[i])
 * 最后我们只需要统计 dp[n-1][m] 中有几个方案为 true 即可。
 * <p>
 * 注意点：题目要求至少取一个值，即全部都不取（结果为0）的方案是不成立的
 * 而我们这里是认为一个都不取的方案是成立的，因此结果需要 减去1.
 * <p>
 * 关于 多重背包问题 的详细解析与解法优化可以参考：
 * https://github.com/cherryljr/LintCode/edit/master/Backpack%20VII.java
 */
public class BackPackVIII {

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
