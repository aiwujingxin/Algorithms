package leetcode;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/19 20:39
 */
public class LeetCode139_trie {

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String string : wordDict) {
            trie.insert(string);
        }
        return trie.find(s, 0);
    }

    static class Trie {
        public TrieNode root = new TrieNode();
        boolean[] failed = new boolean[301]; // s.length <= 300

        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                if (node.children[word.charAt(i) - 'a'] == null) {
                    node.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                node = node.children[word.charAt(i) - 'a'];
            }
            node.isEnd = true;
        }


        public boolean find(String s, int index) {
            if (failed[index]) {
                return false;
            }
            if (index >= s.length()) {
                return true;
            }
            TrieNode p = root;
            for (int i = index; i < s.length(); i++) {
                if (p.children[s.charAt(i) - 'a'] == null) {
                    return false;
                }
                p = p.children[s.charAt(i) - 'a'];
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
            public TrieNode[] children;
            public boolean isEnd;

            public TrieNode() {
                this.children = new TrieNode[26];
                this.isEnd = false;
            }
        }
    }
}