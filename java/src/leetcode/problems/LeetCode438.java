package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/29 18:45
 */
public class LeetCode438 {

    public List<Integer> findAnagrams(String s, String p) {
        int[] sFreq = new int[26];
        int[] pFreq = new int[26];
        int target = 0;
        for (int i = 0; i < p.length(); i++) {
            if (pFreq[p.charAt(i) - 'a'] == 0) {
                target++;
            }
            pFreq[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        int cnt = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            sFreq[c - 'a']++;
            if (sFreq[c - 'a'] == pFreq[c - 'a']) {
                cnt++;
            }
            while (cnt == target) {
                if (right - left + 1 == p.length()) {
                    list.add(left);
                }
                char d = s.charAt(left);
                if (sFreq[d - 'a'] == pFreq[d - 'a']) {
                    cnt--;
                }
                sFreq[d - 'a']--;
                left++;
            }
            right++;
        }
        return list;
    }
}
