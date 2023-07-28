package leetcode.plan.algorithm.level1;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/10 19:54
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int j = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j);
        }
        return max;
    }
}
