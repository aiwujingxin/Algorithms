package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/19 15:09
 * @description 排列组合
 */
public class LeetCode357 {

    public int countNumbersWithUniqueDigits(int n) {
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
