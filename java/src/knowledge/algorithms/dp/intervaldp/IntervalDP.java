package knowledge.algorithms.dp.intervaldp;

import knowledge.algorithms.dp.intervaldp.problems.*;
import leetcode.problems.*;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/28 23:00
 * @description 区间DP 将一个区间划分为若干子区间，通过合并子区间的最优解，构造出整个区间的最优解。
 * <枚举方式>
 * 1) 基于两侧端点讨论的可能性展开
 * 2) 基于范围上划分点的可能性展开
 * <划分方式>
 * 分割点k: 在问题中的物理意义，明确其归属。
 * 1) 开区间: 分割点属于左子问题, 右子问题从 k+1 开始
 * 2) 闭区间: 分割点独立处理, 左右子问题不包含 k
 * <基础>
 * @see AcWing282          石子合并 相邻2堆
 * @see MatrixChain        矩阵链乘法
 * @see LeetCode312        戳气球
 * @see MinCostPalindrome  增删字母得到回文的最小花费
 * @see TriangleDivision   最小三角剖分代价
 * <石子合并>
 * @see LeetCode1000 石子合并 相邻k堆
 * @see LeetCode877  石子游戏 博弈
 * <题单>
 * @see LeetCode5    最长回文子串
 * @see LeetCode87   扰乱字符
 * @see LeetCode375  猜数字大小II
 * @see LeetCode486  预测赢家
 * @see LeetCode516  最长回文子串
 * @see LeetCode1312 让字符串成为回文串的最少插入次数
 * @see LeetCode546  移除盒子
 * @see LeetCode678  有效的括号字符串
 * @see LeetCode1039 多边形三角剖分的最低得分
 * @see LeetCode1216 验证回文串 III
 * @see LeetCode2811 判断是否能拆分数组
 * @see LeetCode1547 切棍子的最小成本
 * @see AcWing283    多边形游戏
 * LeetCode1690
 * LeetCode2312
 * LeetCode1130
 * LeetCode730       统计不同回文子序列
 * LeetCode664
 * LeetCode1147      段式回文
 * LeetCode471
 * POJ3280
 */
public interface IntervalDP {
       /*
      1. k 属于左子区间 : 适用于分割点k属于子问题的情况（如矩阵链乘法）。
                 [i, j]
                /     \
            [i, k]   [k+1, j]      <-- 枚举分割点 k，划分子区间
              / \       / \
           ...   ...  ...  ...

        dp[i][j] = min/max(dp[i][k] + dp[k+1][j] + mergeCost)


      2.  适用于分割点k独立于子问题的情况（如气球问题）。
                 [i, j]
                /      \
            [i, k]    [k, j]      <-- 枚举插入点 k（k 独立于子区间）
              / \      /  \
           ...   ...  ...  ...

        dp[i][j] = max(dp[i][k] + dp[k][j] + mergeCost)
    */

    //1. 按区间长度递增: 斜着遍历
    private int intervalDP1(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {         // 区间长度
            for (int l = 1; l < n - len + 1; l++) { // 枚举起点
                int r = l + len - 1;                // 区间终点
                for (int k = l; k < r; k++) {       // 枚举分割点，构造状态转移方程
                    dp[l][r] = Math.max(dp[l][r], dp[l][k] + dp[k + 1][r] + mergeCost(l, k, r, nums));
                }
            }
        }
        return dp[0][n - 1];
    }

    //2. 按从下向上遍历: i 倒序，j 正序
    private int intervalDP2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j <= n; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + mergeCost(i, k, j, nums));
                }
            }
        }
        return dp[0][n - 1];
    }

    // DFS + 记忆化
    private int intervalDFS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n]; // 初始化记忆化数组（可能需要用Integer[][]以便标记未计算）
        for (int[] row : memo) Arrays.fill(row, -1); // 初始化为-1表示未计算
        return dfs(nums, 0, n - 1, memo); // 处理整个区间[0, n-1]
    }

    // 递归函数：计算区间[l, r]的最优解
    private int dfs(int[] nums, int l, int r, int[][] memo) {
        // 1. 递归终止条件
        if (l > r) return 0; // 空区间（根据问题调整）
        if (l == r) return nums[l]; // 单元素区间（示例值，根据问题调整）
        // 2. 查记忆化表
        if (memo[l][r] != -1) return memo[l][r];
        // 3. 枚举所有可能的分割点k（开区间或闭区间取决于问题）
        int res = 0;
        for (int k = l; k < r; k++) { // 或 k <= r（如戳气球问题）
            // 分割为子问题[l, k]和[ k+1, r]，并合并结果
            int left = dfs(nums, l, k, memo);
            int right = dfs(nums, k + 1, r, memo);
            int cost = left + right + mergeCost(l, k, r, nums); // 合并代价（问题相关）
            res = Math.max(res, cost); // 或 min，根据问题需求
        }
        // 4. 记录结果并返回
        memo[l][r] = res;
        return res;
    }

    // 合并子问题的代价（根据具体问题实现）
    private int mergeCost(int l, int k, int r, int[] nums) {
        return 0;
    }
}
