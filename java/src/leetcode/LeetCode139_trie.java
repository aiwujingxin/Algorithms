package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/7 22:53
 */
public class LeetCode139_trie {
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();

        for (String word : wordDict) {
            trie.insert(word.toCharArray());
        }
        return trie.find(s, 0);
    }

    static class Trie {
        private final TrieNode root = new TrieNode();
        boolean[] failed = new boolean[301]; // s.length <= 300

        public void insert(char[] text) {
            TrieNode p = root;
            for (char c : text) {
                if (p.children[c - 'a'] == null) {
                    p.children[c - 'a'] = new TrieNode();
                }
                p = p.children[c - 'a'];
            }
            p.isEnd = true;
        }

        public boolean find(String s, int i) {
            if (failed[i]) {
                return false;
            }
            if (i >= s.length()) {
                return true;
            }
            TrieNode p = root;
            for (; i < s.length(); i++) {
                int index = s.charAt(i) - 'a';
                if (p.children[index] == null) {
                    return false;
                }
                p = p.children[index];
                if (p.isEnd) {
                    if (find(s, i + 1)) {
                        return true;
                    }
                    failed[i + 1] = true;
                }
            }
            return false;
        }

        static class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public boolean isEnd = false;
        }
    }
}
