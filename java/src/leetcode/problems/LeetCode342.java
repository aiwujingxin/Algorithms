package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/17 18:40
 */
public class LeetCode342 {

    public boolean isPowerOfFour(int n) {
        while (n > 1 && n % 4 == 0) {
            n = n / 4;
        }
        return n == 1;

    }
}
