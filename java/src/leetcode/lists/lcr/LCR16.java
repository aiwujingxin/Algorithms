package leetcode.lists.lcr;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 15:04
 */
public class LCR16 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int len = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (left < right && map.get(c) > 1) {
                char d = s.charAt(left);
                map.put(d, map.getOrDefault(d, 0) - 1);
                left++;
            }
            if (right - left + 1 > len) {
                len = right - left + 1;
            }
            right++;
        }
        return len;
    }
}
