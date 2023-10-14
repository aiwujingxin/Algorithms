package leetcode.lists.lcr;

import basic.datastructure.trie.Trie;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 00:06
 */
public class LCR64 {

    class MagicDictionary {
        Trie trie;

        public MagicDictionary() {
            trie = new Trie();
        }

        public void buildDict(String[] dictionary) {
            for (String d : dictionary) {
                trie.insert(d);
            }
        }
        public boolean search(String searchWord) {
            return trie.searchUpdate(searchWord, trie.root, 0, false);
        }
    }
}
