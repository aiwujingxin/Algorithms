package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/14 18:10
 * @see LeetCode424
 */
public class LeetCode1156 {

    public int maxRepOpt1(String text) {
        int[] freq = new int[26];
        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }
        int[] window = new int[26];
        int ans = 0;
        int maxCount = 0;
        int left = 0;
        int right = 0;
        while (right < text.length()) {
            char c = text.charAt(right);
            window[c - 'a']++;

            if (freq[c - 'a'] - 1 > maxCount) {
                maxCount = Math.max(maxCount, window[c - 'a']);
            }

            while (right - left + 1 > maxCount + 1) {
                window[text.charAt(left) - 'a']--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
