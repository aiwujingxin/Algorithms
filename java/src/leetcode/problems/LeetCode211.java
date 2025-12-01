package leetcode.problems;


import knowledge.datastructure.string.trie.Trie;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 13:36
 */
public class LeetCode211 {
    class WordDictionary {
        private final Trie tr;

        public WordDictionary() {
            tr = new Trie();
        }

        public void addWord(String word) {
            tr.insert(word);
        }

        public boolean search(String word) {
            return dfs(word, 0, tr.root);
        }

        private boolean dfs(String word, int index, Trie.Node node) {
            if (index == word.length()) {
                return node.isEnd;
            }
            char c = word.charAt(index);
            if (c != '.') {
                Trie.Node child = node.children[c - 'a'];
                return child != null && dfs(word, index + 1, child);
            } else {
                for (int i = 0; i < 26; i++) {
                    Trie.Node child = node.children[i];
                    if (child != null && dfs(word, index + 1, child)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
