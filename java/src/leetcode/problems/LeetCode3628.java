package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 9/1/25 13:03
 */
public class LeetCode3628 {

    public long numOfSubsequences(String s) {
        long extra = Math.max(Math.max(numDistinct(s, "CT"), numDistinct(s, "LC")), calcInsertC(s.toCharArray()));
        return numDistinct(s, "LCT") + extra;
    }

    // 115. 不同的子序列
    public long numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        long[][] dp = new long[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    // 计算插入 C 额外产生的 LCT 子序列个数的最大值
    private long calcInsertC(char[] s) {
        int cntT = 0;
        for (char c : s) {
            if (c == 'T') {
                cntT++;
            }
        }
        long res = 0;
        int cntL = 0;
        for (char c : s) {
            if (c == 'T') {
                cntT--;
            }
            if (c == 'L') {
                cntL++;
            }
            res = Math.max(res, (long) cntL * cntT);
        }
        return res;
    }
}
