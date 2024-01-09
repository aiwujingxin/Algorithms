package leetcode.problems;


import knowledge.datastructure.trie.Trie;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/3 13:36
 */
public class LeetCode211 {
    class WordDictionary {
        private final Trie trieTree;

        public WordDictionary() {
            trieTree = new Trie();
        }

        public void addWord(String word) {
            trieTree.insert(word);
        }

        public boolean search(String word) {
            return dfs(word, 0, trieTree.root);
        }

        private boolean dfs(String word, int index, Trie.Node node) {
            if (index == word.length()) {
                return node.isEnd;
            }
            char ch = word.charAt(index);
            if (Character.isLetter(ch)) {
                int childIndex = ch - 'a';
                Trie.Node child = node.children[childIndex];
                if (child != null && dfs(word, index + 1, child)) {
                    return true;
                }
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
