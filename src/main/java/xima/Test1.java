package xima;

import java.util.HashMap;

public class Test1 {


    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }

    static class Solution {
        public String lengthOfLongestSubstring(String s) {

            if (s == null || s.length() == 0) {
                return "";
            }
            String result = "";
            int j = -1;
            int res = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {

                if (map.containsKey(s.charAt(i))) {
                    j = Math.max(j, map.get(s.charAt(i)));
                    result = i - j > result.length() ? s.substring(j, i) :result;
                }
                map.put(s.charAt(i), i);
                res = Math.max(res, i - j);
            }
            return result;
        }
    }
}
