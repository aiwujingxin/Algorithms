package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/25 00:09
 */
public class LeetCode343_fast {


    public int integerBreak(int n) {

        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int timesOf3 = n / 3;
        if (n - timesOf3 * 3 == 2) {
            timesOf3 = 1;
        }
        int timesOf2 = (n - timesOf3 * 3) / 2;
        return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
    }
}
