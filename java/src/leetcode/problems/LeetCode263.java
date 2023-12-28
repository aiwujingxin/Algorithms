package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/28 15:56
 */
public class LeetCode263 {
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        return n == 1;
    }
}
