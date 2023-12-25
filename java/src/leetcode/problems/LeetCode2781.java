package leetcode.problems;

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

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    static class Trie {

        TrieNode root = new TrieNode();

        public void insert(String s) {
            TrieNode cur = root;
            for (int i = 0; i < s.length(); i++) {
                if (cur.children[s.charAt(i) - 'a'] == null) {
                    cur.children[s.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.children[s.charAt(i) - 'a'];
            }
            cur.isEnd = true;
        }

        public int contains(String s, int left, int right) {
            TrieNode cur = root;
            int index;
            for (index = left; index <= right; index++) {
                if (cur.children[s.charAt(index) - 'a'] == null) {
                    return -1;
                }
                cur = cur.children[s.charAt(index) - 'a'];
                if (cur.isEnd) {
                    return index;
                }
            }
            return -1;
        }
    }
}
