package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/9 16:26
 */
public class LeetCode1312 {

    public int minInsertions(String s) {
        return s.length() - new LeetCode516().longestPalindromeSubseq(s);
    }
}
