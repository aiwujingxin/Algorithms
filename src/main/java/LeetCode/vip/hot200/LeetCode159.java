package LeetCode.vip.hot200;

import java.util.Collections;
import java.util.HashMap;

/**
 * @author jingxinwu
 * @date 2022-01-25 11:24 PM
 */
public class LeetCode159 {


    /*
      给定一个字符串 s ，找出至多包含两个不同字符的最长子串t，并返回该子串的长度。

      示例 1:

      输入: "eceba"
      输出: 3
      解释: t 是 "ece"，长度为3。
      示例 2:

      输入: "cabbage"
      输出: 5
      解释: t 是 "aabbb"，长度为5。
     */

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        if (n < 3) {
            return n;
        }
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> hashmap = new HashMap<>();
        int maxLen = 2;
        while (right < n) {
            if (hashmap.size() < 3) {
                hashmap.put(s.charAt(right), right++);
            }
            if (hashmap.size() == 3) {
                // delete the leftmost character
                int del_idx = Collections.min(hashmap.values());
                hashmap.remove(s.charAt(del_idx));
                // move left pointer of the slidewindow
                left = del_idx + 1;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;

    }
}
