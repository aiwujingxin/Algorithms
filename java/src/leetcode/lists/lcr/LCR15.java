package leetcode.lists.lcr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 15:09
 */
public class LCR15 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

        int[] pArr = new int[26];
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
            set.add(p.charAt(i));
        }
        int target = set.size();
        int[] window = new int[26];
        int left = 0;
        int right = 0;
        int count = 0;
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            window[c - 'a']++;
            if (window[c - 'a'] == pArr[c - 'a']) {
                count++;
            }
            while (right - left + 1 > p.length()) {
                char d = s.charAt(left);
                if (window[d - 'a'] == pArr[d - 'a']) {
                    count--;
                }
                window[s.charAt(left) - 'a']--;
                left++;
            }
            if (count == target) {
                res.add(left);
            }
            right++;
        }
        return res;
    }
}
