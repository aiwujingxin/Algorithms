package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 11/24/25 14:37
 */
public class LeetCode1593 {
    int max = 0;

    public int maxUniqueSplit(String s) {
        // 使用 HashSet 更符合语义，因为我们只关心 key 是否存在
        backtrack(s, 0, new HashSet<>());
        return max;
    }

    private void backtrack(String s, int i, Set<String> set) {
        // 剪枝条件
        // 如果当前已有的子串数 + 剩余字符串的长度 <= 已找到的最大值，
        // 那么这条路不可能产生更优解，直接返回。
        if (set.size() + (s.length() - i) <= max) {
            return;
        }

        if (i == s.length()) {
            max = Math.max(max, set.size());
            return;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            String t = s.substring(i, j);
            if (set.contains(t)) {
                continue;
            }

            set.add(t);
            backtrack(s, j, set);
            set.remove(t);
        }
    }
}
