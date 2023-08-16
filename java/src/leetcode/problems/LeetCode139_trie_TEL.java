package leetcode.problems;

import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/9 13:04
 */
public class LeetCode139_trie_TEL {

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();

        for (String word : wordDict) {
            trie.insert(word.toCharArray());
        }

        return trie.find(s, 0);
    }

    static class Trie {

        private final TrieNode root = new TrieNode('/');

        public void insert(char[] text) {
            TrieNode p = root;
            for (char c : text) {
                int index = c - 'a';
                if (p.children[index] == null) {
                    TrieNode newNode = new TrieNode(c);
                    p.children[index] = newNode;
                }
                p = p.children[index];
            }
            p.isEndingChar = true;
        }

        public boolean find(String s, int i) {
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
                if (p.isEndingChar) {
                    if (find(s, i + 1)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    static class TrieNode {
        public char data;
        public TrieNode[] children = new TrieNode[26]; // 使用数组保存结果
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
