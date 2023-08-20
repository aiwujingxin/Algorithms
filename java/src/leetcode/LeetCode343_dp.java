package leetcode;

/**
 * @author jingxinwu
 * @date 2021-06-05 4:54 下午
 */
public class LeetCode343_dp {

    public static void main(String[] args) {
        LeetCode343_dp leetCode343 = new LeetCode343_dp();
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
}
