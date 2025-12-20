package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 12/10/25 11:36
 */
public class LeetCode1297 {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int max = 0;
        int n = s.length();
        for (int len = minSize; len <= maxSize; len++) {
            int[] freq = new int[26];
            int cnt = 0;
            HashMap<String, Integer> ans = new HashMap<>();
            int left = 0;
            int right = 0;
            while (right < n) {
                char c = s.charAt(right);
                freq[c - 'a']++;
                if (freq[c - 'a'] == 1) cnt++;
                while (right - left + 1 > len) {
                    char d = s.charAt(left);
                    freq[d - 'a']--;
                    if (freq[d - 'a'] == 0) cnt--;
                    left++;
                }
                if (right - left + 1 == len && cnt <= maxLetters) {
                    ans.merge(s.substring(left, right + 1), 1, Integer::sum);
                }
                right++;
            }
            for (Map.Entry<String, Integer> val : ans.entrySet()) {
                max = Math.max(max, val.getValue());
            }
        }
        return max;
    }
}
