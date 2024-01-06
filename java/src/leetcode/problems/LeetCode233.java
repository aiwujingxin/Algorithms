package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2023/2/26 21:32
 * @description 本质是回溯+记忆化，回溯参数是什么记忆化的就是什么
 */
public class LeetCode233 {

    char[] chars;
    int[][] memo;

    public int countDigitOne(int n) {
        chars = Integer.toString(n).toCharArray();
        int m = chars.length;
        memo = new int[m][m];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, true);
    }

    /**
     * @param cnt1    表示前面填了多少个 1
     * @param isLimit 表示当前是否受到了n的约束（前面填的数字都是 n 对应位上的），如果为 true，那么当前位至多为 (s[i]-‘0’)否则至多为'9'。
     *                且如果在受到约束的情况下填了 s[i]，那么后续填入的数字仍会受到 n的约束。
     *                <p>
     *                看题目是否区别前导零，例如 0102 和 102 是否会对答案有不同的影响。
     *                本题只需要统计 1，按照有前导零的方式统计，还是按照没有前导零的方式统计，算出来的结果是一样的，所以不需要考虑是否有前导零。
     */
    int dfs(int i, int cnt1, boolean isLimit) {
        if (i == chars.length) {
            return cnt1;
        }
        if (!isLimit && memo[i][cnt1] != -1) {
            return memo[i][cnt1];
        }
        int res = 0;
        int upper = isLimit ? chars[i] - '0' : 9;
        for (int d = 0; d <= upper; d++) {
            res += dfs(i + 1, cnt1 + (d == 1 ? 1 : 0), isLimit && d == upper);
        }
        //memo记录在不受到约束时的合法方案数，所以要在 !isLimit 成立时才去记忆化。
        if (!isLimit) {
            memo[i][cnt1] = res;
        }
        return res;
    }
}
