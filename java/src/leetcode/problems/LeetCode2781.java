package leetcode.problems;

import knowledge.datastructure.string.match.Trie;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/12/25 21:44
 */
public class LeetCode2781 {

    public int longestValidSubstring(String word, List<String> forbidden) {
        if (forbidden == null || forbidden.isEmpty()) {
            return word.length();
        }
        Trie trie = new Trie();
        for (String f : forbidden) {
            trie.insert(f);
        }
        int n = word.length();
        int max = 0;
        int left = n - 1;
        int right = n - 1;
        while (left >= 0) {
            int index = trie.contains(word, left, right);
            if (index != -1) {
                right = index - 1;
            } else {
                max = Math.max(max, right - left + 1);
            }
            left--;
        }
        return max;
    }
}
