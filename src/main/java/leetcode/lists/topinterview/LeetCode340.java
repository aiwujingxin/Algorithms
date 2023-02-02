package leetcode.lists.topinterview;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 18:31
 */
public class LeetCode340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();
        int maxLength = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char curr = s.charAt(right);
            counts.put(curr, counts.getOrDefault(curr, 0) + 1);
            while (counts.size() > k) {
                char prev = s.charAt(left);
                counts.put(prev, counts.get(prev) - 1);
                if (counts.get(prev) == 0) {
                    counts.remove(prev);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
