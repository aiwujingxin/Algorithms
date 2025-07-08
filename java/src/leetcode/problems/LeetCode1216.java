package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/2/8 23:01
 */
public class LeetCode1216 {

    public boolean isValidPalindrome(String s, int k) {
        return s.length() - new LeetCode516().longestPalindromeSubseq(s) <= k;
    }
}