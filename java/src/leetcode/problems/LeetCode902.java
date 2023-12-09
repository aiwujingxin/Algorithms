package leetcode.problems;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/9 22:10
 */
public class LeetCode902 {

    private String[] digits;
    private char[] chars;
    private int[] memo;

    public int atMostNGivenDigitSet(String[] digits, int n) {
        this.digits = digits;
        chars = Integer.toString(n).toCharArray();
        memo = new int[chars.length];
        Arrays.fill(memo, -1);
        return dfs(0, true, false);
    }

    private int dfs(int index, boolean isLimit, boolean isNum) {
        if (index == chars.length) {
            return isNum ? 1 : 0; // 如果填了数字，则为 1 种合法方案
        }
        if (!isLimit && isNum && memo[index] >= 0) {
            return memo[index]; // 在不受到任何约束的情况下，返回记录的结果，避免重复运算
        }
        int res = 0;
        if (!isNum) // 前面不填数字，那么可以跳过当前数位，也不填数字
            // isLimit 改为 false，因为没有填数字，位数都比 n 要短，自然不会受到 n 的约束
            // isNum 仍然为 false，因为没有填任何数字
            res = dfs(index + 1, false, false);
        int up = isLimit ? chars[index] : '9'; // 根据是否受到约束，决定可以填的数字的上限
        // 注意：对于一般的题目而言，如果此时 isNum 为 false，则必须从 1 开始枚举，由于本题 digits 没有 0，所以无需处理这种情况
        for (String d : digits) { // 枚举要填入的数字 d
            if (d.charAt(0) > up) {
                break; // d 超过上限，由于 digits 是有序的，后面的 d 都会超过上限，故退出循环
            }
            // isLimit：如果当前受到 n 的约束，且填的数字等于上限，那么后面仍然会受到 n 的约束
            // isNum 为 true，因为填了数字
            res += dfs(index + 1, isLimit && d.charAt(0) == up, true);
        }
        if (!isLimit && isNum) {
            memo[index] = res; // 在不受到任何约束的情况下，记录结果
        }
        return res;
    }
}
