package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/6 18:14
 */
public class LeetCode159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (left < right && map.size() > 2) {
                char d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                if (map.get(d) == 0) {
                    map.remove(d);
                }
                left++;
            }
            if (map.size() <= 2) {
                max = Math.max(max, right - left + 1);
            }
            right++;
        }

        return max;
    }
}
