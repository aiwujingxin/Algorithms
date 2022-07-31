package LeetCode;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/29 00:21
 */
public class LeetCode1278_dp_twice {

    public int palindromePartition(String s, int k) {
        int length = s.length();
        //palindrome[i][j]表示子串[i,j]转化为回文串所需要的修改的字符数
        int[][] palindrome = new int[length][length];
        //一行一行的从下往上（只遍历右上部分）
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                palindrome[i][j] = palindrome[i + 1][j - 1] + (s.charAt(i) == s.charAt(j) ? 0 : 1);
            }
        }

        //dp[i][j]表示s的前i个字符分割成k个回文子串的最少次数,
        //第一行和第一列应该都是0。
        int[][] dp = new int[length + 1][k + 1];
        for (int i = 1; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        //前i个字符，分割成j个回文子串
        for (int i = 1; i <= length; i++) {
            int len = Math.min(i, k);
            for (int j = 1; j <= len; j++) {
                if (j == 1)//字符串的下标是从0开始的，所以这里要减1
                    dp[i][j] = palindrome[j - 1][i - 1];
                else {
                    for (int m = j - 1; m < i; m++) {
                        dp[i][j] = Math.min(dp[i][j], dp[m][j - 1] + palindrome[m][i - 1]);
                    }
                }
            }
        }
        return dp[length][k];
    }
}
