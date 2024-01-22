package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/7/4 23:16
 */
public class LeetCode2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int ans = 1;
        int count = 0;
        while (right < s.length()) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                count++;
            }
            if (count > 1) {
                left++;
                while (s.charAt(left) != s.charAt(left - 1)) {
                    left++;
                }
                count = 1;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
