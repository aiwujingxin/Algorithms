package leetcode.problems;


import knowledge.datastructure.string.match.Trie;

import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/25 00:05
 */
public class LeetCode648 {

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
