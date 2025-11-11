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
        return modPow(x, a);
    }

    public double modPow(double a, long b) {
        double res = 1;
        while (b > 0) {
            if ((b & 1) != 0) res *= a;
            a *= a;
            b >>= 1;
        }
        return res;
    }

    class Solution_dfs {

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
            double h = dfs(x, n / 2);
            return n % 2 == 0 ? h * h : h * h * x;
        }
    }

    class Solution_dfs2 {
        // 尾递归
        public double myPow(double x, int n) {
            long a = n;
            if (a < 0) {
                a = -a;
                x = 1 / x;
            }
            return dfs(x, a, 1);
        }

        private double dfs(double x, long a, double r) {
            if (a == 0) return r;
            return (a % 2 == 1) ? dfs(x * x, a / 2, r * x) : dfs(x * x, a / 2, r);
        }
    }
}
