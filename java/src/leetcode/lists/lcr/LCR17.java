package leetcode.lists.lcr;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/23 15:21
 */
public class LCR17 {

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
            sArr.put(s.charAt(right), sArr.getOrDefault(s.charAt(right), 0) + 1);
            if (Objects.equals(sArr.get(s.charAt(right)), tArr.get(s.charAt(right)))) {
                valid++;
            }
            while (valid == target) {
                if (right - left + 1 < len) {
                    start = left;
                    len = right - left + 1;
                }
                char d = s.charAt(left);
                if (Objects.equals(sArr.get(d), tArr.getOrDefault(d, 0))) {
                    valid--;
                }
                sArr.put(d, sArr.getOrDefault(d, 0) - 1);
                left++;
            }
            right++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
