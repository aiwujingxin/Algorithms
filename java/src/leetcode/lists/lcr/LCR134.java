package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 15:57
 */
public class LCR134 {

    public double myPow(double x, int n) {
        long a = n;
        if (a < 0) {
            a = -a;
            x = 1 / x;
        }
        return myPowH(x, a);
    }

    private double myPowH(double a, long b) {
        double res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res *= a;
            a *= a;
            b >>= 1;
        }
        return res;
    }
}
