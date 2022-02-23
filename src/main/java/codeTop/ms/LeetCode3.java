package codeTop.ms;

import java.util.HashMap;

/**
 * @author jingxinwu
 * @date 2022-02-16 7:25 PM
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        int j = -1;
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j);

        }
        return res;

    }

}
