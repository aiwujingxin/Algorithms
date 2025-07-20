package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/12 13:24
 * @description dp[i] 的变化不是单调递增的 —— 不是越长越多
 */
public class LeetCode91 {

    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[n + 1];
        char[] ch = s.toCharArray();
        dp[0] = 1;
        dp[1] = ch[0] == '0' ? 0 : 1; // 第一个字符不能是0
        for (int i = 2; i <= n; i++) {
            if (ch[i - 1] != '0') {
                dp[i] = dp[i - 1];
            }
            int num = (ch[i - 2] - '0') * 10 + (ch[i - 1] - '0');
            if (ch[i - 2] != '0' && num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
