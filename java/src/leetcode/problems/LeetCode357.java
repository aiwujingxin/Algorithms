package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/7 01:05
 */
public class LeetCode357 {

    char[] chars;
    int[][] memo;

    public int countNumbersWithUniqueDigits(int n) {
        String s = String.valueOf((int) Math.pow(10, n) - 1);
        chars = s.toCharArray();
        int m = chars.length;
        memo = new int[m][1 << 10];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, true, false) + 1;
    }

    private int dfs(int i, int mask, boolean isLimit, boolean isNum) {
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];
        }
        if (i == chars.length) {
            return isNum ? 1 : 0;
        }
        int res = 0;
        if (!isNum) {
            res = dfs(i + 1, mask, false, false);
        }
        int low = isNum ? 0 : 1;
        int up = isLimit ? chars[i] - '0' : 9;
        for (int d = low; d <= up; d++) {
            if ((mask >> d & 1) == 0) {
                res += dfs(i + 1, mask | (1 << d), isLimit && (up == d), true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = res;
        }
        return res;
    }

    public int countNumbersWithUniqueDigits_math(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 10;
        }
        int res = 10, cur = 9;
        for (int i = 0; i < n - 1; i++) {
            cur *= 9 - i;
            res += cur;
        }
        return res;
    }
}
