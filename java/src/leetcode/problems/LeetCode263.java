package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/28 15:56
 */
public class LeetCode263 {

    public boolean isUgly(int n) {
        if (n <= 0) return false;
        for (int f : new int[]{2, 3, 5}) {
            while (n % f == 0) {
                n /= f;
            }
        }
        return n == 1;
    }
}
