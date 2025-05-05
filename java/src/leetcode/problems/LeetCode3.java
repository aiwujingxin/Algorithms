package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:28
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int max = 0;
        int[] window = new int[128];
        char[] chars = s.toCharArray();
        while (right < n) {
            char c = chars[right];
            window[c]++;
            while (left < right && window[c] > 1) {
                char d = chars[left];
                window[d]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
