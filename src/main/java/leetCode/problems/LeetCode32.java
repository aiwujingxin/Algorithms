package leetCode.problems;

/**
 * @author jingxinwu
 * @date 2021-11-26 7:29 下午
 */
public class LeetCode32 {


    public int longestValidParentheses(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 0;
        dp[1] = 1;

        return 0;

    }

}
