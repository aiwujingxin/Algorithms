package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/2/2 11:44
 */
public class LeetCode2730 {

    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        int left = 0;
        int right = 1;
        int count = 0;
        int max = 1;
        while (right < n) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                count++;
            }
            while (left < right && count > 1) {
                if (s.charAt(left) == s.charAt(left + 1)) {
                    count--;
                }
                left++;
            }
            max = Math.max(right - left + 1, max);
            right++;
        }
        return max;
    }
}
