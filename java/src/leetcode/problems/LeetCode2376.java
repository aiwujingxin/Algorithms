package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/9 21:41
 */
public class LeetCode2376 {

    char[] s;
    int[][] memo;

    public int countSpecialNumbers(int n) {
        s = Integer.toString(n).toCharArray();
        int m = s.length;
        memo = new int[m][1 << 10];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, true, false);
    }

    // 返回从 i 开始填数字， i 前面填的数字的集合是 mask，能构造出的特殊整数的数目。
    // mask 是可选的 没有约束的话可以不要
    // isLimit 表示前面填的数字是否都是 n 对应位上的，如果为 true，那么当前位至多为 int(s[i]), 否则至多为'9'
    // isNum 表示前面是否填了数字（是否跳过），true 那么当前位可以从 0 开始，如果为 false，那么我们可以跳过，或者从 1 开始填数字
    int dfs(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];
        }
        int res = 0;
        if (!isNum) {  // 跳过当前数位，不填数字
            res = dfs(i + 1, mask, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; ++d) { // 枚举要填入的数字 d；枚举的范围取决于 isLimit 和 isNum
            if ((mask >> d & 1) == 0) { // d 不在 mask 中
                res += dfs(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = res;
        }
        return res;
    }
}
