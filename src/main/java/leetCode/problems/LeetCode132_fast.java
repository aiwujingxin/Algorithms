package leetCode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/7/17 15:50
 */
public class LeetCode132_fast {

    public int minCut(String s) {
        int length = s.length();
        if (length == 1) return 0;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = i;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < length; i++) {
            findMin(chars, i, i, dp);
            findMin(chars, i, i + 1, dp);
        }
        return dp[length - 1];
    }

    public void findMin(char[] chars, int i, int j, int[] dp) {
        while (i >= 0 && j < chars.length && chars[i] == chars[j]) {
            dp[j] = Math.min(dp[j], i == 0 ? 0 : dp[i - 1] + 1);
            i--;
            j++;
        }
    }
}
