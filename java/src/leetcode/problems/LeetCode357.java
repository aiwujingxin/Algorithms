package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/6 13:20
 */
public class LeetCode357 {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int res = 1;
        for (int len = 1; len <= n; len++) {
            res += A(10, len) - A(9, len - 1);
        }
        return res;
    }

    private int A(int n, int m) {
        int ret = 1;
        for (int i = n; i > n - m; i--) {
            ret *= i;
        }
        return ret;
    }
}
