package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 18:45
 */
public class LeetCode438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        int[] pArr = new int[26];
        int[] sArr = new int[26];

        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < p.length(); i++) {
            pArr[p.charAt(i) - 'a']++;
            set.add(p.charAt(i));
        }

        int target = set.size();
        int count = 0;
        int left = 0;
        int right = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            int c = s.charAt(right);
            sArr[c - 'a']++;

            if (sArr[c - 'a'] == pArr[c - 'a']) {
                count++;
            }
            while (right - left + 1 > p.length()) {
                char d = s.charAt(left);
                if (sArr[d - 'a'] == pArr[d - 'a']) {
                    count--;
                }
                sArr[d - 'a']--;
                left++;
            }
            if (count == target) {
                list.add(left);
            }
            right++;
        }
        return list;
    }
}
