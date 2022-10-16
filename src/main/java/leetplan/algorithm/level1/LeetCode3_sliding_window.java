package leetplan.algorithm.level1;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 22:06
 */
public class LeetCode3_sliding_window {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        int res = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            map.put(c, map.getOrDefault(c, 0) + 1);

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
