package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/10 12:44
 */
public class LeetCode76 {

    public String minWindow(String s, String t) {
        if (s == null || s.isEmpty() || (s.length() < t.length())) {
            return "";
        }
        int left = 0;
        int right = 0;
        int count = 0;


        int start = 0;
        int len = Integer.MAX_VALUE;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
            set.add(t.charAt(i));
        }
        int target = set.size();
        while (right < s.length()) {
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if (Objects.equals(sMap.get(c), tMap.get(c))) {
                count++;
            }

            while (count == target && right - left + 1 >= t.length()) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    start = left;
                }
                char d = s.charAt(left);
                if (Objects.equals(sMap.get(d), tMap.getOrDefault(d, 0))) {
                    count--;
                }
                sMap.put(d, sMap.getOrDefault(d, 0) - 1);
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
