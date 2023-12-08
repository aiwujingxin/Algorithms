package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/26 21:32
 */
public class LeetCode233 {

    char[] s;
    int[][] memo;

    public int countDigitOne(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        memo = new int[m][m];
        for (var i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return dfs(0, 0, true);
    }

    int dfs(int i, int cnt1, boolean isLimit) {
        if (i == s.length) {
            return cnt1;
        }

        if (!isLimit && memo[i][cnt1] >= 0) {
            return memo[i][cnt1];
        }

        var res = 0;
        for (int d = 0, up = isLimit ? s[i] - '0' : 9; d <= up; ++d) {
            // 枚举要填入的数字 d
            res += dfs(i + 1, cnt1 + (d == 1 ? 1 : 0), isLimit && d == up);
        }
        if (!isLimit) {
            memo[i][cnt1] = res;
        }
        return res;
    }
}
