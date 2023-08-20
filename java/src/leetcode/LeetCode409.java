package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jingxinwu
 * @date 2021-12-12 3:16 PM
 */
public class LeetCode409 {

    public static void main(String[] args) {
        System.out.println(new LeetCode409().longestPalindrome("dccaccd"));
        System.out.println(new LeetCode409().longestPalindrome("bb"));
        System.out.println(new LeetCode409().longestPalindrome("ccc"));
        System.out.println(new LeetCode409().longestPalindrome("cccaa"));
        System.out.println(new LeetCode409().longestPalindrome("tattarrattat"));
        System.out.println(new LeetCode409().longestPalindrome("ababababa"));
    }

    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        if (map.keySet().size() == 1) {
            for (Map.Entry<Character, Integer> en : map.entrySet()) {
                return en.getValue();
            }
        }
        int res = 0;
        boolean flag = false;
        for (Map.Entry<Character, Integer> en : map.entrySet()) {
            int value = en.getValue();
            if (value % 2 == 1) {
                flag = true;
            }
            res = res + value / 2;
        }
        return res * 2 + (flag ? 1 : 0);
    }
}
