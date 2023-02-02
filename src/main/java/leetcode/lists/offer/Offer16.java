package leetcode.lists.offer;

/**
 * @author jingxinwu
 * @date 2021-11-21 2:17 下午
 */
public class Offer16 {

    public double myPow(double x, int n) {
        boolean flag = false;
        if (n < 0) {
            flag = true;
            x = 1 / x;
            n = -(n + 1);
        }

        double res = 1;
        double temp = x;

        while (n != 0) {
            if (n % 2 == 1) {
                res *= temp;
            }
            temp *= temp;
            n = n / 2;
        }

        if (flag) {
            res *= x;
        }

        return res;
    }
}
