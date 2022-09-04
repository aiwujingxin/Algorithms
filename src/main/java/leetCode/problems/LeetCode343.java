package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-06-05 4:54 下午
 */
public class LeetCode343 {

    public static void main(String[] args) {
        LeetCode343 leetCode343 = new LeetCode343();
        System.out.println(leetCode343.integerBreak(6));
    }


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
        int max;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i < n; i++) {
            max = 0;
            for (int j = 1; j < i / 2; j++) {
                int product = dp[j] * dp[i - j];
                if (max < product) {
                    max = product;
                }
                dp[i] = max;
            }
        }

        return dp[dp.length - 1];
    }

    public int integerBreakV3(int n) {

        if (n < 4) {
            return n - 1;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(Math.max(2 * (i - 2), 2 * dp[i - 2]), Math.max(3 * (i - 3), 3 * dp[i - 3]));
        }
        return dp[n];

    }


    public int integerBreakV4(int n) {

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

    public int integerBreakV2(int n) {
        return helper(n, n);
    }

    public int helper(int n, int m) {
        if (n < 1 || m < 1) {
            return 0;
        }
        if (n == 1 || m == 1) {
            return 1;
        }

        if (n < m) {
            return helper(n, n);
        }

        if (n == m) {
            return helper(n, m - 1) + 1;
        }

        return helper(n, m - 1) + helper(n - m, m);
    }
}
