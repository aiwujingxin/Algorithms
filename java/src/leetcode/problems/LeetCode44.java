package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 14:58
 * @link <a href="https://www.youtube.com/watch?v=G3Pq0IUvkY4"></a>
 */
public class LeetCode44 {

    public boolean isMatch(String ss, String pp) {
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        int m = s.length;
        int n = p.length;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 初始化 p 为空串匹配 s 的情况（只可能是连续的 '*'）
        for (int j = 1; j <= n; j++) {
            if (p[j - 1] == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                break;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                 /* 等价于:
                    for (int k = 0; k <= i; k++) {
                        if (dp[k][j - 1]) {
                            dp[i][j] = true;
                            break;
                        }
                    }
                    推导:
                    通过状态递推，一步步“累积”结果，而不是 O(n²) 地重新遍历一遍。
                    i = 0
                    dp[0][j] = dp[0][j-1]   // * 匹配 0 个字符
                    i = 1
                    dp[1][j] = dp[0][j] || dp[1][j-1]
                    i = 2
                    dp[2][j] = dp[1][j] || dp[2][j-1]
                            = (dp[0][j-1] || dp[1][j-1]) || dp[2][j-1]
                            = dp[0][j-1] || dp[1][j-1] || dp[2][j-1]
                    i = N - 1
                    dp[i-1][j]=  dp[0][j-1] || dp[1][j-1] || dp[2][j-1] || ... || dp[i-1][j-1]
                    i = N
                    dp[i][j]  = dp[0][j-1] || dp[1][j-1] || dp[2][j-1] || ... || dp[i-1][j-1] || dp[i][j-1]
                    代入 dp[i-1][j]得:
                    dp[i][j]  =  dp[i-1][j] || dp[i][j-1]
                    */
            }
        }
        return dp[m][n];
    }
}
