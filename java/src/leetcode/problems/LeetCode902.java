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
            return isNum ? 1 : 0;
        }
        if (!isLimit && isNum && memo[index] >= 0) {
            return memo[index];
        }
        int res = 0;
        if (!isNum) {
            res = dfs(index + 1, false, false);
        }
        int up = isLimit ? chars[index] - '0' : 9;
        for (String d : digits) {
            if (Integer.parseInt(d) > up) {
                break;
            }
            res += dfs(index + 1, isLimit && Integer.parseInt(d) == up, true);
        }
        if (!isLimit && isNum) {
            memo[index] = res;
        }
        return res;
    }
}
