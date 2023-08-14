package leetcode.problems;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/9/27 23:01
 */
public class LeetCode212 {

    //https://leetcode.com/problems/word-break-ii/discuss/2182648/Java-or-1ms-or-99-or-Trie-%2B-Backtracking-%2B-HashSet
    TrieNode root = new TrieNode();
    boolean[][] flag;

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        flag = new boolean[board.length][board[0].length];

        addToTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.child[board[i][j] - 'a'] != null) {
                    search(board, i, j, root, "", result);
                }
            }
        }

        return new LinkedList<>(result);
    }

    private void search(char[][] board, int i, int j, TrieNode node, String word, Set<String> result) {
        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || flag[i][j]) {
            return;
        }

        if (node.child[board[i][j] - 'a'] == null) {
            return;
        }

        flag[i][j] = true;
        node = node.child[board[i][j] - 'a'];
        if (node.isEnd) {
            result.add(word + board[i][j]);
        }

        search(board, i - 1, j, node, word + board[i][j], result);
        search(board, i + 1, j, node, word + board[i][j], result);
        search(board, i, j - 1, node, word + board[i][j], result);
        search(board, i, j + 1, node, word + board[i][j], result);

        flag[i][j] = false;

    }

    private void addToTrie(String[] words) {
        for (String word : words) {
            if (word == null || word.length() == 0) {
                return;
            }
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur.child[word.charAt(i) - 'a'] == null) {
                    cur.child[word.charAt(i) - 'a'] = new TrieNode();
                }
                cur = cur.child[word.charAt(i) - 'a'];
            }
            cur.isEnd = true;
        }
    }

    private static class TrieNode {

        public boolean isEnd = false;
        public TrieNode[] child = new TrieNode[26];

        public TrieNode() {

        }
    }
}
