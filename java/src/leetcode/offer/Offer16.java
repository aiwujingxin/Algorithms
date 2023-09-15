package leetcode.offer;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/12 15:57
 */
public class Offer16 {

    public double myPow(double x, int n) {
        double res = myPowH(x, n);
        return n < 0 ? 1 / res : res;
    }

    private double myPowH(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return myPowH(x * x, n / 2);
        } else {
            return myPowH(x * x, n / 2) * x;
        }
    }
}
