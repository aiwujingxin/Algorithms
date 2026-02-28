package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/11 20:35
 */
public class LeetCode30 {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> counts = new HashMap<>();
        for (String w : words) counts.merge(w, 1, Integer::sum);
        int num = words.length;
        int len = words[0].length();
        int max = len * (num - 1);
        int target = counts.size();
        for (int i = 0; i < len; i++) {
            Map<String, Integer> window = new HashMap<>();
            int left = i, right = i, valid = 0;
            while (right + len <= s.length()) {
                String w = s.substring(right, right + len);
                window.merge(w, 1, Integer::sum);
                if (window.get(w).equals(counts.get(w))) valid++;
                if (right - left == max) {
                    if (valid == target) res.add(left);
                    String d = s.substring(left, left + len);
                    if (window.get(d).equals(counts.get(d))) valid--;
                    window.merge(d, -1, Integer::sum);
                    left += len;
                }
                right += len;
            }
        }
        return res;
    }
}
