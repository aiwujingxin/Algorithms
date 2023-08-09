package leetcode.problems;

import java.util.*;

/**
 * @author jingxinwu
 * @date 2021-06-14 11:41 上午
 */
public class LeetCode3 {


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)), i + 1);
            }
            max = Math.max(max, i - j + 1);
            map.put(s.charAt(i), i);
        }
        return max;
    }
}
