package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/31 13:57
 */
public class LeetCode1208 {

    public int equalSubstring(String s, String t, int maxCost) {
        int diff = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        int max = 0;
        while (right < n) {
            diff += Math.abs(s.charAt(right) - t.charAt(right));
            while (left < right && diff > maxCost) {
                diff -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            if (diff <= maxCost) {
                max = Math.max(max, right - left + 1);
            }
            right++;
        }
        return max;
    }
}
