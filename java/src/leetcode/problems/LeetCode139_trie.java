package leetcode.problems;

import basic.datastructure.trie.Trie;

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
        return trie.wordBreak(s, 0);
    }
}