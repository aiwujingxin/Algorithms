package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/8 17:14
 */
public class LeetCode600 {

    char[] s;
    int[][] dp;

    public int findIntegers(int n) {
        s = Integer.toBinaryString(n).toCharArray();
        int m = s.length;
        dp = new int[m][2];
        for (var i = 0; i < m; i++) Arrays.fill(dp[i], -1);
        return dfs(0, false, true);
    }

    int dfs(int i, boolean pre1, boolean isLimit) {
        if (i == s.length) {
            return 1;
        }
        if (!isLimit && dp[i][pre1 ? 1 : 0] >= 0) {
            return dp[i][pre1 ? 1 : 0];
        }
        int up = isLimit ? s[i] - '0' : 1;
        int res = dfs(i + 1, false, isLimit && up == 0); // 填 0
        if (!pre1 && up == 1) {
            res += dfs(i + 1, true, isLimit); // 填 1
        }
        if (!isLimit) {
            dp[i][pre1 ? 1 : 0] = res;
        }
        return res;
    }
}
