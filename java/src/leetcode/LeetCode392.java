package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/23 15:07
 */
public class LeetCode392 {

    //"axc"
    //"ahbgdc"
    public static void main(String[] args) {
        System.out.println(new LeetCode392().isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];

        for (int i = 0; i <= t.length(); i++) {
            dp[0][i] = true;
        }

        //s的前i个字符 是否是 t的前j个字符的子序列
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
