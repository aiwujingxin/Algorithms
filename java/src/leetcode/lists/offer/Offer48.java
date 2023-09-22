package leetcode.lists.offer;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 23:24
 */
public class Offer48 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.get(c) > 1) {
                char d = s.charAt(left);
                map.put(d, map.getOrDefault(d, 0) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
