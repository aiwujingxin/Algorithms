package leetcode.lists.interview;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/7 00:44
 */
public class Inter1706 {

    char[] s;
    int[][] memo;

    public int numberOf2sInRange(int n) {
        s = Integer.toString(n).toCharArray();
        var m = s.length;
        memo = new int[m][m];
        for (var i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(0, 0, true);
    }

    int f(int i, int cnt2, boolean isLimit) {
        if (i == s.length) return cnt2;
        if (!isLimit && memo[i][cnt2] >= 0) {
            return memo[i][cnt2];
        }
        var res = 0;
        for (int d = 0, up = isLimit ? s[i] - '0' : 9; d <= up; ++d) // 枚举要填入的数字 d
            res += f(i + 1, cnt2 + (d == 2 ? 1 : 0), isLimit && d == up);
        if (!isLimit) {
            memo[i][cnt2] = res;
        }
        return res;
    }
}
