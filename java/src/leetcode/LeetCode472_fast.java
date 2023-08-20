package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/31 22:36
 */
public class LeetCode472_fast {

    Trie trie;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Arrays.sort(words, (word1, word2) -> word1.length() - word2.length());
        trie = new Trie();
        for (String word : words) {
            if (dfs(word, 0)) {
                res.add(word);
            } else {
                trie.insert(word);
            }

        }
        return res;
    }

    public boolean dfs(String s, int index) {
        if (index > 0 && index == s.length()) {

            return true;
        }
        Trie t = trie;
        for (int i = index; i < s.length(); i++) {
            int k = s.charAt(i) - 'a';
            if (t.tree[k] == null) {
                return false;
            }

            t = t.tree[k];
            if (t.valid && dfs(s, i + 1)) {
                return true;
            }

        }
        return false;
    }


    static class Trie {
        Trie[] tree;
        boolean valid;

        public Trie() {
            valid = false;
            tree = new Trie[26];
        }

        public void insert(String s) {
            Trie t = this;
            for (int i = 0; i < s.length(); i++) {
                int k = s.charAt(i) - 'a';
                if (t.tree[k] == null) {
                    t.tree[k] = new Trie();
                }
                t = t.tree[k];
            }
            t.valid = true;
        }
    }
}
