package leetcode.lists.lcr;

import java.util.HashSet;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 15:16
 */
public class LCR14 {

    public boolean checkInclusion(String s1, String s2) {
        int[] need = new int[26];
        HashSet<Character> set = new HashSet<>();
        int[] window = new int[26];
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
            set.add(c);
        }
        int left = 0, right = 0, count = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            window[c - 'a']++;
            if (need[c - 'a'] == window[c - 'a']) {
                count++;
            }
            while (right - left == s1.length()) {
                if (count == set.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                if (need[d - 'a'] == window[d - 'a']) {
                    count--;
                }
                window[d - 'a']--;
                left++;
            }
        }
        return false;
    }
}
