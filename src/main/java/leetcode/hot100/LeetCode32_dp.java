package leetcode.hot100;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/3 19:03
 */
public class LeetCode32_dp {

    //https://leetcode.cn/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/

    public int longestValidParentheses(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 三块构成
                    dp[i] = dp[i - 1] + 2 + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
