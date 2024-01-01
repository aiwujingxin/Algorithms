package leetcode.problems;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-12-25 3:48 PM
 */
public class LeetCode395 {

    //https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/solution/by-adoring-lederbergck6-mwic/
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int max = 0;
        char[] ch = s.toCharArray();
        int[] cnt = new int[26];
        for (int p = 1; p <= 26; p++) {//枚举字符出现种类数
            Arrays.fill(cnt, 0);
            int left = 0, right = 0;
            int charCount = 0;
            int validCount = 0;
            while (right < n) {
                cnt[ch[right] - 'a']++;
                if (cnt[ch[right] - 'a'] == 1) {
                    charCount++;
                }
                if (cnt[ch[right] - 'a'] == k) {
                    validCount++;
                }
                while (charCount > p) {
                    if (cnt[ch[left] - 'a'] == 1) {
                        charCount--;
                    }
                    if (cnt[ch[left] - 'a'] == k) {
                        validCount--;
                    }
                    cnt[ch[left] - 'a']--;
                    left++;
                }
                if (charCount == validCount) {
                    max = Math.max(right - left + 1, max);
                }
                right++;
            }
        }
        return max;
    }
}
