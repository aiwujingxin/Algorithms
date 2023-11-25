package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 00:25
 * @description 单词
 * @see LeetCode438
 */
public class LeetCode30 {

    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        Map<String, Integer> target = new HashMap<>();
        for (String str : words) {
            target.put(str, target.getOrDefault(str, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int left = 0; left < w; left++) {
            Map<String, Integer> window = new HashMap<>();
            // 滑动窗口的大小固定是 m * w
            for (int right = left; right + w <= n; right += w) {
                String cur = s.substring(right, right + w);
                window.put(cur, window.getOrDefault(cur, 0) + 1);
                if (right >= left + (m * w)) {
                    int index = right - m * w;
                    String delete = s.substring(index, index + w);
                    if (window.get(delete) == 1) {
                        window.remove(delete);
                    } else {
                        window.put(delete, window.get(delete) - 1);
                    }
                }
                if (window.equals(target)) {
                    ans.add(right - (m - 1) * w);
                }
            }
        }
        return ans;
    }
}
