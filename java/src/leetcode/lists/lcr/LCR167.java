package leetcode.lists.lcr;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/13 23:24
 */
public class LCR167 {

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            map.merge(c, 1, Integer::sum);
            while (map.get(c) > 1) {
                map.merge(s.charAt(left), -1, Integer::sum);
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
