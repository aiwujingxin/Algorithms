package leetcode.offer;

/**
 * @author jingxinwu
 * @date 2021-11-19 10:08 下午
 */
public class Offer10_1 {

    /**
     * 输入：n = 5
     * 输出：5
     */


    public static void main(String[] args) {
        Offer10_1 offer10_1 = new Offer10_1();
        System.out.println(offer10_1.fib(9));
    }

    public int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[dp.length - 1] % 1000000007;
    }
}
