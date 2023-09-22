package leetcode.problems;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/6 18:14
 */
public class LeetCode159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;
        int max = 0;

        while (right < s.length()) {

            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            right++;

            if (map.size() <= 2) {
                max = Math.max(max, right - left);
            }

            while (left < right && map.size() > 2) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                if (map.get(s.charAt(left)) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
        }

        return max;
    }
}
