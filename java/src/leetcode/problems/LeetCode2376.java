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
        return dfs(0, 0, true, false); // 初始化
    }

    /**
     * 返回从i开始填数字，能构造出的特殊整数的数目。i前面填的数字的集合是mask
     *
     * @param i       当前数位
     * @param mask    是可选的。没有约束的话可以不要; 本题约束为数字只能出现一次
     * @param isLimit 表示前面填的数字是否都是 n 对应位上的，如果为 true，那么当前位至多为 (s[i]-‘0’), 否则至多为'9'
     * @param isNum   表示上一位是否填过数字，则当前有两种选择: 要么继续跳过，要么当前位从 0 (preIsNum=true) or 1 (preIsNum=false) 开始填数字
     */
    int dfs(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == chars.length) {
            return isNum ? 1 : 0;  // 如果填了数字，则为 1 种合法方案
        }
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];  // 在不受到任何约束的情况下，返回记录的结果，避免重复运算
        }
        int res = 0;
        if (!isNum) {  // 继续跳过，当前位不填数字
            // 前面不填数字，那么可以跳过当前数位，也不填数字
            // isLimit 改为 false，因为没有填数字，位数都比 n 要短，自然不会受到 n 的约束
            // isNum 仍然为 false，因为没有填任何数字
            res = dfs(i + 1, mask, false, false);
        }
        // 不跳过
        int low = isNum ? 0 : 1;
        int up = isLimit ? chars[i] - '0' : 9; // 根据是否受到约束，决定可以填的数字的上限
        for (int d = low; d <= up; d++) { // 枚举要填入的数字 d
            if ((mask >> d & 1) == 0) { // d 不在 visit 中
                // isLimit：如果当前受到 n 的约束，且填的数字等于上限，那么后面仍然会受到 n 的约束
                // isNum 为 true，因为填了数字
                res += dfs(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = res; // 在不受到任何约束的情况下，记录结果
        }
        return res;
    }
}
