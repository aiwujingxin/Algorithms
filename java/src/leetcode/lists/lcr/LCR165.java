package leetcode.lists.lcr;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 23:25
 */
public class LCR165 {

    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        char[] chars = String.valueOf(num).toCharArray();
        int n = chars.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int a = (chars[0] - '0') * 10 + (chars[1] - '0');
        if (a >= 10 && a < 26) {
            dp[1] = 2;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1];
            int t = (chars[i - 1] - '0') * 10 + (chars[i] - '0');
            if (t >= 10 && t < 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[dp.length - 1];
    }
}
