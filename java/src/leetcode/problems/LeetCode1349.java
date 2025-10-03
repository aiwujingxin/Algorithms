package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/4 00:33
 * @description 枚举子集 <a href="https://leetcode.cn/problems/maximum-students-taking-exam/solutions/2580043/jiao-ni-yi-bu-bu-si-kao-dong-tai-gui-hua-9y5k/"></a>
 */
public class LeetCode1349 {

    public int maxStudents(char[][] seats) {
        int m = seats.length;
        int n = seats[0].length;
        int[] a = new int[m]; // a[i] 是第 i 排可用椅子的下标集合
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '.') {
                    a[i] |= 1 << j;
                }
            }
        }
        int[][] dp = new int[m][1 << n];
        for (int j = 1; j < (1 << n); j++) {
            int lb = j & -j;
            dp[0][j] = dp[0][j & ~(lb * 3)] + 1;
        }
        for (int i = 1; i < m; i++) {                           // 阶段
            for (int j = a[i]; j > 0; j = (j - 1) & a[i]) {     // 状态 枚举 a[i] 的子集 j
                // 第 i 排空着
                dp[i][j] = dp[i - 1][a[i - 1]];
                for (int k = j; k > 0; k = (k - 1) & j) {       // 决策 枚举 j 的子集 k
                    // k 没有连续的 1
                    if ((k & (k >> 1)) == 0) {
                        // 去掉不能坐人的位置
                        int t = a[i - 1] & ~(k << 1 | k >> 1);
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][t] + dp[0][k]);
                    }
                }
            }
            dp[i][0] = dp[i - 1][a[i - 1]];
        }
        return dp[m - 1][a[m - 1]];
    }
}
