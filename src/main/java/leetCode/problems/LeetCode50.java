package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-06-24 12:40 上午
 */
public class LeetCode50 {

    public static void main(String[] args) {
        LeetCode50 leetCode50 = new LeetCode50();
        System.out.println(leetCode50.myPow(2.00000, -2147483648));
    }

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
