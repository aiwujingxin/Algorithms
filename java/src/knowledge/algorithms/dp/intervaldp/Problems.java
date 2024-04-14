package knowledge.algorithms.dp.intervaldp;

import knowledge.algorithms.dp.intervaldp.problems.*;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 23:00
 * @description 区间DP
 * <基础>
 * @see MatrixChain 矩阵链乘法
 * @see LeetCode1039 多边形三角剖分的最低得分
 * @see LeetCode312 戳气球
 * <石子合并>
 * @see AcWing282 石子合并 相邻2堆
 * @see LeetCode1000 石子合并 相邻k堆
 * @see LeetCode877 石子游戏
 * @see LeetCode1049 最后一块石头的重量 II
 * <题单>
 * @see LeetCode87 扰乱字符
 * @see LeetCode375 猜数字大小 II
 * @see LeetCode1312 让字符串成为回文串的最少插入次数
 * @see LeetCode546 移除盒子
 * @see LeetCode486 预测赢家
 * @see LeetCode678 有效的括号字符串
 * @see LeetCode1216
 * LeetCode1547
 * LeetCode1690
 * LeetCode2312
 * LeetCode1130
 * LeetCode730 统计不同回文子序列
 * LeetCode664
 * LeetCode1147 段式回文
 * LeetCode471
 * POJ3280
 */
public interface Problems {

    // 迭代式
    private void intervalDP(int n) {
        int[][] dp = new int[n][n];
        for (int r = 2; r < n; r++) {
            for (int i = 1; i < n - r + 1; i++) {
                int j = i + r - 1;
                for (int k = i; k < j; k++) {
                    int cost = 0;
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k + 1][j] + cost);
                }
            }
        }
    }
}
