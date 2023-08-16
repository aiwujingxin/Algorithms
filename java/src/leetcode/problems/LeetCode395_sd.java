package leetcode.problems;

import java.util.Arrays;

/**
 * @author jingxinwu
 * @date 2021-12-25 3:48 PM
 */
public class LeetCode395_sd {

    //https://leetcode.cn/problems/longest-substring-with-at-least-k-repeating-characters/solution/by-adoring-lederbergck6-mwic/
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int ans = 0;
        char[] ch = s.toCharArray();
        int[] hash = new int[26];
        for (int p = 1; p <= 26; p++) {
            Arrays.fill(hash, 0);
            int left = 0, right = 0;
            int charCount = 0;
            int validCount = 0;
            while (right < n) {
                hash[ch[right] - 'a']++;
                if (hash[ch[right] - 'a'] == 1) {
                    charCount++;
                }
                if (hash[ch[right] - 'a'] == k) {
                    validCount++;
                }
                while (charCount > p) {
                    if (hash[ch[left] - 'a'] == 1) {
                        charCount--;
                    }
                    if (hash[ch[left] - 'a'] == k) {
                        validCount--;
                    }
                    hash[ch[left] - 'a']--;
                    left++;
                }
                if (charCount == validCount) {
                    ans = Math.max(right - left + 1, ans);
                }
                right++;
            }
        }
        return ans;
    }
}
