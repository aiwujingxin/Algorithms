package leetplan.dp.level1;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 13:38
 */
public class LeetCode509 {

    public static void main(String[] args) {
        System.out.println(new LeetCode509().fib(6));
    }

    public int fib(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[dp.length - 1];
    }
}
