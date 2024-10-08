package leetcode.lists.lcci;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/7 00:44
 */
public class LCCI1706 {

    char[] chars;
    int[][] memo;

    public int numberOf2sInRange(int n) {
        chars = Integer.toString(n).toCharArray();
        int m = chars.length;
        memo = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, true);
    }

    int dfs(int i, int cnt2, boolean isLimit) {
        if (i == chars.length) {
            return cnt2;
        }
        if (!isLimit && memo[i][cnt2] >= 0) {
            return memo[i][cnt2];
        }
        int res = 0;
        int up = isLimit ? chars[i] - '0' : 9;

        for (int d = 0; d <= up; ++d) { // 枚举要填入的数字 d
            res += dfs(i + 1, cnt2 + (d == 2 ? 1 : 0), isLimit && d == up);
        }
        if (!isLimit) {
            memo[i][cnt2] = res;
        }
        return res;
    }
}
