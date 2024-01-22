package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/15 21:47
 */
public class LeetCode320 {

    // todo 题解
    public List<String> generateAbbreviations(String word) {
        if (word == null || word.isEmpty()) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        res.add(word);
        backtrack(word, res, 0);
        return new ArrayList<>(res);
    }

    private void backtrack(String word, Set<String> res, int start) {
        if (start == word.length()) {
            return;
        }
        for (int i = start; i <= word.length(); i++) {
            for (int j = i + 1; j <= word.length(); j++) {
                String t = word;
                String sb = word.substring(0, i) + (j - i) + word.substring(j);
                res.add(sb);
                // important fixed bug 下一次开始的位置
                int left = word.length() - 1 - j;
                backtrack(sb, res, sb.length() - left);
                word = t;
            }
        }
    }
}
