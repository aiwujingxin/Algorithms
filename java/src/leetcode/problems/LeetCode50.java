package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 14:45
 */
public class LeetCode50 {

    public double myPow(double x, int n) {
        long a = n;
        if (a < 0) {
            a = -a;
            x = 1 / x;
        }
        return dfs(x, a);
    }

    private double dfs(double x, long n) {
        if (n == 0) return 1;
        double half = dfs(x, n / 2);
        return n % 2 == 0 ? half * half : half * half * x;
    }

    public double myPow_iter(double x, int n) {
        long a = n;
        if (a < 0) {
            a = -a;
            x = 1 / x;
        }
        double res = 1;
        while (a > 0) {
            if ((a & 1) == 1) {
                res *= x;
            }
            x *= x;
            a >>= 1;
        }
        return res;
    }
}
