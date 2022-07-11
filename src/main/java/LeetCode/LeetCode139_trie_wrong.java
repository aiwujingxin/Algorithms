package LeetCode;

import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/9 13:07
 */
public class LeetCode139_trie_wrong {



    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode('/');
        for (String word : wordDict) {
            TrieNode tmp = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (tmp.children[index] == null)
                    tmp.children[index] = new TrieNode(c);
                tmp = tmp.children[index];
            }
            tmp.isEndingChar = true;
        }

        int index = 0;
        TrieNode p = root;
        while (index < s.length()) {
            p = root;
            while (true) {
                int i = s.charAt(index) - 'a';
                if (p.children[i] == null) {
                    return false;
                }
                p = p.children[i];
                index++;
                if (p.isEndingChar)
                    break;
                if (index == s.length())
                    return false;
            }
        }
        return true;
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
