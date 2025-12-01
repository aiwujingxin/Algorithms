package leetcode.lists.lcr;


import knowledge.datastructure.string.trie.Trie;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/24 23:49
 */
public class LCR63 {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String s : dictionary) {
            trie.insert(s);
        }
        String[] strs = sentence.split(" ");
        String[] words = sentence.split(" ");
        for (int i = 0; i < strs.length; i++) {
            words[i] = trie.findRoot(words[i]);
        }
        return String.join(" ", words);
    }
}
