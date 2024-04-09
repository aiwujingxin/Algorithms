package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 10:28
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int n = s.length();
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < n) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (left < right && map.get(c) > 1) {
                char d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
