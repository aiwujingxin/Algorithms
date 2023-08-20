package leetcode.offer;

import java.util.HashMap;

/**
 * @author jingxinwu
 * @date 2021-11-24 12:14 上午
 */
public class Offer48 {

    public static void main(String[] args) {
        System.out.println(new Offer48().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Offer48().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Offer48().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Offer48().lengthOfLongestSubstring("au"));
        System.out.println(new Offer48().lengthOfLongestSubstring("dvdf"));
    }


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int res = Integer.MIN_VALUE;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }
            res = Math.max(res, i - j + 1);
            map.put(s.charAt(i), i);
        }
        return res;
    }

}
