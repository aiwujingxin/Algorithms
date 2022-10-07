package leetcode.topinterview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/28 01:22
 */
public class LeetCode140 {

    //study
    TrieNode root;

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return new ArrayList<>();
        }
        root = new TrieNode();
        for (String word : wordDict) {
            insert(word);
        }

        Set<String> res = new HashSet<>();
        TrieNode temp = root;

        backtrack(s, new StringBuilder(), temp, res, 0);
        return new ArrayList<>(res);
    }

    private void backtrack(String s, StringBuilder sb, TrieNode temp, Set<String> res, int index) {
        if (index >= s.length() && temp.isEnd) {
            res.add(sb.toString());
        } else if (index < s.length()) {
            TrieNode next = temp.childs[s.charAt(index) - 'a'];
            if (next != null) {
                sb.append(s.charAt(index));
                // blah
                StringBuilder tempSb = new StringBuilder(sb.toString());

                // pretend that the current word in the StringBuilder is not a finished word
                backtrack(s, sb, next, res, index + 1);

                // If the word is finished add the space and start from the head of the trie
                if (next.isEnd && !res.contains(tempSb.toString())) {
                    tempSb.append(" ");
                    backtrack(s, tempSb, root, res, index + 1);
                }
            }
        }
    }


    static class TrieNode {
        public TrieNode() {
            childs = new TrieNode[26];
            isEnd = false;
        }

        TrieNode[] childs;
        boolean isEnd;
    }

    private void insert(String s) {
        if (s == null || s.length() == 0) {
            return;
        }
        TrieNode cur = root;
        for (int i = 0; i < s.length(); i++) {
            if (cur.childs[s.charAt(i) - 'a'] == null) {
                cur.childs[s.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.childs[s.charAt(i) - 'a'];
        }
        cur.isEnd = true;
    }

}
