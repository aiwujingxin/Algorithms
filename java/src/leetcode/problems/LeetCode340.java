package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 18:31
 */
public class LeetCode340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char d = s.charAt(left);
                map.put(d, map.get(d) - 1);
                if (map.get(d) == 0) {
                    map.remove(d);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
