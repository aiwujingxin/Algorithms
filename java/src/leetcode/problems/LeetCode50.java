package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 14:45
 */
public class LeetCode50 {

    public double myPow(double x, int n) {
        long m = n;
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }
        return pow(x, m);
    }

    private double pow(double x, long n) {
        if (n == 0) return 1;
        double half = pow(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

    public double myPow_iter(double x, int n) {
        long m = n;
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }
        double res = 1;
        while (m > 0) {
            if ((m & 1) == 1) {
                res *= x;
            }
            x *= x;
            m >>= 1;
        }
        return res;
    }
}
