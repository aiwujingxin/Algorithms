package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/9 21:41
 * @see LeetCode1012
 */
public class LeetCode2376 {

    char[] chars;
    int[][] memo;

    public int countSpecialNumbers(int n) {
        chars = Integer.toString(n).toCharArray();
        int m = chars.length;
        memo = new int[m][1 << 10];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, true, false);
    }

    /**
     * 返回从i开始填数字，能构造出的特殊整数的数目。i前面填的数字的集合是mask
     *
     * @param mask    是可选的。没有约束的话可以不要; 本题约束为数字只能出现一次
     * @param isLimit 表示前面填的数字是否都是 n 对应位上的，如果为 true，那么当前位至多为 (s[i]-‘0’), 否则至多为'9'
     * @param isNum   表示上一位是否填过数字，则当前有两种选择: 要么继续跳过，要么当前位从 0 or 1 开始填数字
     */
    int dfs(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == chars.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];
        }
        int res = 0;
        if (!isNum) {  // 继续跳过，当前位不填数字
            res = dfs(i + 1, mask, false, false);
        }
        // 不跳过
        int upper = isLimit ? chars[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= upper; d++) { // 枚举要填入的数字 d；枚举的范围取决于 isLimit 和 isNum
            if ((mask >> d & 1) == 0) { // d 不在 mask 中
                res += dfs(i + 1, mask | (1 << d), isLimit && d == upper, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = res;
        }
        return res;
    }
}
