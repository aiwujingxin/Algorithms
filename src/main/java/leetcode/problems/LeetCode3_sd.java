package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/4 22:48
 */
public class LeetCode3_sd {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            right++;
            while (map.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                map.put(d, map.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
