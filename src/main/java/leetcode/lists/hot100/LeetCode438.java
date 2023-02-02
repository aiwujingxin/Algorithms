package leetcode.lists.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/20 02:10
 */
public class LeetCode438 {

    public List<Integer> findAnagrams(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0, count = 0;
        List<Integer> list = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    count++;
                }
            }
            //只有在right - left == need.size()的情况下才有可能有符合条件的解
            while (right - left >= t.length()) {
                if (count == need.size()) {
                    list.add(left);
                }
                char d = s.charAt(left);
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        count--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
                left++;
            }
        }
        return list;
    }
}
