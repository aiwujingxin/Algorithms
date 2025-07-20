package knowledge.algorithms.dp.intervaldp;

import knowledge.algorithms.dp.intervaldp.problems.*;
import leetcode.lists.lcci.*;
import leetcode.problems.*;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2025/07/07 01:00
 * @description 区间DP  将一个区间划分为若干子区间，通过合并子区间的最优解，构造出整个区间的最优解。
 * <两侧端点展开>
 * @see LeetCode5        最长回文子串
 * @see LeetCode516      最长回文子序列
 * @see LeetCode1312     让字符串成为回文串的最少插入次数
 * @see LeetCode1216     验证回文串 III
 * @see LeetCode664      奇怪的打印机
 * @see LeetCode730      统计不同回文子序列
 * @see ValidParentheses 括号区间匹配
 * @see LeetCode32       最长有效括号
 * <范围划分点展开>
 * @see AcWing282        石子合并 相邻2堆
 * @see MatrixChain      矩阵链乘法
 * @see LeetCode312      戳气球
 * @see LeetCode1039     多边形三角剖分的最低得分
 * @see LeetCode1000     石子合并 相邻k堆
 * @see LeetCode87       扰乱字符
 * @see LeetCode96       不同的二叉搜索树
 * @see LeetCode375      猜数字大小II
 * @see LeetCode546      移除盒子
 * @see LeetCode1547     切棍子的最小成本
 * @see LeetCode1130     叶值的最小代价生成树
 * @see LeetCode2104     子数组范围和
 * @see LeetCode2312     卖木头块
 * @see AcWing283        多边形游戏
 * @see LCCI0814         布尔运算
 * <博弈类>
 * @see GameDP           博弈类DP
 * <回文类>
 * @see PalindromeDP     回文类DP
 */
public interface IntervalDP {
       /*
                 [i, j]
                /     \
            [i, k]   [k(+1), j]      <-- 枚举分割点 k，划分子区间
              / \       / \
           ...   ...  ...  ...

        dp[i][j] = min/max(dp[i][k] + dp[k(+1)][j] + cost)
    */

    //1. 按区间长度递增: 斜着遍历
    private int intervalD_len(int[] nums) {
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
    private int interval_iter(int[] nums) {
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
        int[][] memo = new int[n][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(nums, 0, n - 1, memo);
    }

    private int dfs(int[] nums, int l, int r, int[][] memo) {
        if (l > r) return 0;
        if (l == r) return nums[l];
        if (memo[l][r] != -1) return memo[l][r];
        int res = 0;
        for (int k = l; k < r; k++) {
            res = Math.max(res, dfs(nums, l, k, memo) + dfs(nums, k + 1, r, memo) + mergeCost(l, k, r, nums));
        }
        return memo[l][r] = res;
    }

    private int mergeCost(int l, int k, int r, int[] nums) {
        return 0;
    }
}
