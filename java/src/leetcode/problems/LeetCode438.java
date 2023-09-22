package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/20 21:17
 */
public class LeetCode438 {

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        int left = 0;
        int right = 0;
        int[] arr = new int[26];
        int[] arr1 = new int[26];
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < p.length(); i++) {
            arr1[p.charAt(i) - 'a']++;
            set.add(p.charAt(i));
        }
        int target = set.size();

        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            arr[c - 'a']++;
            if (arr[c - 'a'] == arr1[c - 'a']) {
                count++;
            }
            while (left < right && right - left + 1 > p.length()) {
                char d = s.charAt(left);
                if (arr[d - 'a'] == arr1[d - 'a']) {
                    count--;
                }
                arr[d - 'a']--;
                left++;
            }
            if (right - left + 1 == p.length() && count == target) {
                res.add(left);
            }
            right++;
        }
        return res;
    }
}
