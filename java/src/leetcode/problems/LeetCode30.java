package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/19 17:38
 * @see LeetCode438
 */
public class LeetCode30 {

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        HashMap<String, Integer> target = new HashMap<>();
        for (String word : words) {
            target.put(word, target.getOrDefault(word, 0) + 1);
        }
        int len = words[0].length();
        int cnt = words.length;
        List<Integer> ans = new ArrayList<>();
        for (int left = 0; left < len; left++) {
            HashMap<String, Integer> window = new HashMap<>();
            int right = left;
            while (right + len <= s.length()) {
                String cur = s.substring(right, right + len);
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (right - left + 1 > cnt * len) {
                    int index = right - cnt * len;
                    String d = s.substring(index, index + len);
                    if (window.get(d) == 1) {
                        window.remove(d);
                    } else {
                        window.put(d, window.get(d) - 1);
                    }
                }
                if (window.equals(target)) {
                    ans.add(right - len * (cnt - 1));
                }
                right += len;
            }
        }
        return ans;
    }
}
