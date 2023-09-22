package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/21 13:09
 */
public class LeetCode76 {

    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() < t.length()) {
            return "";
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        HashMap<Character, Integer> sArr = new HashMap<>();
        HashMap<Character, Integer> tArr = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            tArr.put(t.charAt(i), tArr.getOrDefault(t.charAt(i), 0) + 1);
            set.add(t.charAt(i));
        }

        int valid = 0;
        int target = set.size();

        while (right < s.length()) {
            char c = s.charAt(right);
            sArr.put(c, sArr.getOrDefault(c, 0) + 1);
            if (Objects.equals(sArr.get(c), tArr.get(c))) {
                valid++;
            }
            while (valid == target) {
                if (right - left + 1 < len) {
                    start = left;
                    len = right - left + 1;
                }
                char d = s.charAt(left);
                if (sArr.get(d) >= tArr.getOrDefault(d, 0)) {
                    if (Objects.equals(sArr.get(d), tArr.getOrDefault(d, 0))) {
                        valid--;
                    }
                    sArr.put(d, sArr.get(d) - 1);
                }
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}