package leetCode.problems;

import java.util.*;
import java.util.Map;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/31 22:32
 */
public class LeetCode472_trie {

    TrieNode root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        root = new TrieNode();
        List<String> res = new ArrayList<>();
        for (String w : words) {
            if (query(w) >= 2) {
                res.add(w);
            }
            insert(w);
        }
        return res;
    }

    private int query(String w) {
        if (w == null || w.length() == 0) {
            return 0;
        }
        TrieNode node = root;
        int count = -1;
        for (int i = 0; i < w.length(); i++) {
            char ch = w.charAt(i);
            if (!node.children.containsKey(ch)) {
                return count;
            }
            node = node.children.get(ch);
            if (node.isWord) {
                int tmp = query(w.substring(i + 1));
                if (tmp == -1) {
                    continue;
                }
                count = Math.max(count, 1 + tmp);
            }
        }
        return count;
    }

    private void insert(String w) {
        TrieNode node = root;
        for (char ch : w.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isWord = true;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
    }
}
