package leetcode.lists.hot100;

import java.util.HashMap;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/15 22:53
 */
public class LeetCode3 {

    public static void main(String[] args) {
        System.out.println(new LeetCode3().lengthOfLongestSubstring("abc"));
        System.out.println(new LeetCode3().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LeetCode3().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LeetCode3().lengthOfLongestSubstring("pwwkew"));
    }

    //abcabcbb
    //j  i
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int j = -1;
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
