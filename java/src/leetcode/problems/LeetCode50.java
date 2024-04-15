package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/19 14:45
 */
public class LeetCode50 {

    public double myPow(double x, int n) {
        if (x == 1) {
            return x;
        }
        if (n < 0) {
            return 1 / dfs(x, -n);
        }
        return dfs(x, n);
    }

    private double dfs(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            return dfs(x * x, n / 2);
        }
        return x * dfs(x * x, n / 2);
    }

    public double myPow_(double x, int n) {
        return (long) n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -n);
    }

    public double quickMul(double x, long n) {
        double ans = 1.0;
        double t = x;
        while (n > 0) {
            if (n % 2 == 1) {
                ans *= t;
            }
            t *= t;
            n /= 2;
        }
        return ans;
    }
}
