package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/1/19 12:38
 */
public class LeetCode820 {

    //https://leetcode.com/problems/short-encoding-of-words/solutions/125784/trie-solution/
    static class TrieNode {
        HashMap<Character, TrieNode> next = new HashMap<>();
        int depth;
    }

    public int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();
        List<TrieNode> leaves = new ArrayList<>();
        for (String w : new HashSet<>(Arrays.asList(words))) {
            TrieNode cur = root;
            for (int i = w.length() - 1; i >= 0; --i) {
                char j = w.charAt(i);
                if (!cur.next.containsKey(j)) {
                    cur.next.put(j, new TrieNode());
                }
                cur = cur.next.get(j);
            }
            cur.depth = w.length() + 1;
            leaves.add(cur);
        }
        int res = 0;
        for (TrieNode leaf : leaves) {
            if (leaf.next.isEmpty()) {
                res += leaf.depth;
            }
        }
        return res;
    }
}
