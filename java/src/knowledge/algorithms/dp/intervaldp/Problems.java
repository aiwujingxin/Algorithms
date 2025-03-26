package knowledge.algorithms.dp.intervaldp;

import knowledge.algorithms.dp.intervaldp.problems.*;
import leetcode.problems.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 23:00
 * @description 区间DP 大范围的问题拆分成若干小范围的问题来求解
 * 可能性展开的常见方式
 * 1) 基于两侧端点讨论的可能性展开
 * 2) 基于范围上划分点的可能性展开
 * <基础>
 * @see AcWing282    石子合并
 * @see MatrixChain  矩阵链乘法
 * @see LeetCode1039 多边形三角剖分的最低得分
 * @see LeetCode312  戳气球
 * @see LeetCode486  预测赢家
 * <石子合并>
 * @see LeetCode1000 石子合并 相邻k堆
 * @see LeetCode877  石子游戏
 * @see LeetCode1049 最后一块石头的重量II
 * <题单>
 * @see LeetCode1312 让字符串成为回文串的最少插入次数
 * @see LeetCode87   扰乱字符
 * @see LeetCode375  猜数字大小II
 * @see LeetCode546  移除盒子
 * @see LeetCode678  有效的括号字符串
 * @see LeetCode1216
 * @see LeetCode2811
 * @see LeetCode1547 切棍子的最小成本
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

    private void solve(int n) {
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {         // 区间长度
            for (int l = 1; l < n - len + 1; l++) { // 枚举起点
                int r = l + len - 1;                // 区间终点
                for (int k = l; k < r; k++) {       // 枚举分割点，构造状态转移方程
                    int cost = 0;
                    dp[l][r] = Math.max(dp[l][r], dp[l][k] + dp[k + 1][r] + cost);
                }
            }
        }
    }
}
