package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/12/13 19:42
 */
public class LeetCode29_bit {
    public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) {
            return (1 << 31) - 1;
        }
        int a = Math.abs(A), b = Math.abs(B), res = 0;
        while (a >= b) {
            int x = 0;
            while ((a - (b << 1 << x)) > 0) {
                x++;
            }
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }
}
