package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/5 00:35
 */
public class LeetCode263 {
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
