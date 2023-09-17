package leetcode;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/17 16:30
 */
public class LeetCode208 {

    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {
                if (node.children[chars[i] - 'a'] == null) {
                    node.children[chars[i] - 'a'] = new TrieNode();
                }
                node = node.children[chars[i] - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            char[] chars = word.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {
                if (node.children[chars[i] - 'a'] == null) {
                    return false;
                }
                node = node.children[chars[i] - 'a'];
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            char[] chars = prefix.toCharArray();
            TrieNode node = root;
            for (int i = 0; i < chars.length; i++) {
                if (node.children[chars[i] - 'a'] == null) {
                    return false;
                }
                node = node.children[chars[i] - 'a'];
            }
            return true;
        }

        static class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            boolean isEnd = false;
        }
    }

}
