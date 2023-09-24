package leetcode.problems;


import basic.datastructure.trie.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/31 22:36
 */
public class LeetCode472_trie {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (word1, word2) -> word1.length() - word2.length());
        Trie trie = new Trie();
        for (String word : words) {
            if (trie.canBreak(word, 0)) {
                res.add(word);
            } else {
                trie.insert(word);
            }
        }
        return res;
    }
}
