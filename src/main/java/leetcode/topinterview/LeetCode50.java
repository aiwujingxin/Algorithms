package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/22 01:39
 */
public class LeetCode50 {

    //https://www.youtube.com/watch?v=QWphd0kFVh4
    public double myPow(double x, int n) {
        boolean isN = false;
        if (n < 0) {
            x = 1 / x;
            isN = true;
            n = -(n + 1); //防止越界
        }
        double ans = 1;
        double tmp = x;
        while (n != 0) {
            if (n % 2 == 1) {
                ans *= tmp;
            }
            tmp *= tmp;
            n /= 2;
        }

        if (isN) {
            ans *= x; //如果是负数，前面少乘了一次，再乘上
        }
        return ans;
    }
}
