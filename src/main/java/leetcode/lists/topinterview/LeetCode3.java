package leetcode.lists.topinterview;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/20 23:51
 */
public class LeetCode3 {

    public static void main(String[] args) {
        System.out.println(new LeetCode3().lengthOfLongestSubstring("pwwkew"));
    }

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
            max = Math.max(max, i - j);
            map.put(s.charAt(i), i);
        }
        return max;


    }
}
