package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/10/20 00:25
 * @see LeetCode438
 */
public class LeetCode30 {

    //https://leetcode.cn/problems/substring-with-concatenation-of-all-words/solutions/1619194/by-ac_oier-enjd/

    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        // 统计 words 中「每个目标单词」的出现次数
        Map<String, Integer> target = new HashMap<>();
        for (String str : words) {
            target.put(str, target.getOrDefault(str, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int left = 0; left < w; left++) {
            // 构建一个当前子串对应的哈希表，统计当前子串中「每个目标单词」的出现次数
            Map<String, Integer> window = new HashMap<>();
            // 滑动窗口的大小固定是 m * w，维护窗口内的数据，下一个单词追加进 temp，上一个单词移出 temp
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
                    if (!window.getOrDefault(delete, 0).equals(target.getOrDefault(delete, 0))) {
                        continue;
                    }
                }
                if (!window.getOrDefault(cur, 0).equals(target.getOrDefault(cur, 0))) {
                    continue;
                }
                // 上面两个 continue 可以减少 map 之间的 equals 操作, 没有也没关系
                if (window.equals(target)) {
                    ans.add(right - (m - 1) * w);
                }
            }
        }
        return ans;
    }
}
