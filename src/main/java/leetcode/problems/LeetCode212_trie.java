package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/6 22:17
 */
public class LeetCode212_trie {

    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }

        return new ArrayList<>(res);
    }

    public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (visited[x][y]) {
            return;
        }

        str += board[x][y];
        if (!trie.startsWith(str)) {
            return;
        }

        if (trie.search(str)) {
            res.add(str);
        }

        visited[x][y] = true;
        dfs(board, visited, str, x - 1, y, trie);
        dfs(board, visited, str, x + 1, y, trie);
        dfs(board, visited, str, x, y - 1, trie);
        dfs(board, visited, str, x, y + 1, trie);
        visited[x][y] = false;
    }

    static class Trie {

        final private Trie.Node root;

        public Trie() {
            root = new Trie.Node();
        }

        public void insert(String word) {
            Trie.Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.childs[ch - 'a'] == null) {
                    curr.childs[ch - 'a'] = new Trie.Node();
                }
                curr = curr.childs[ch - 'a'];
            }

            curr.isEnd = true;
        }

        public boolean search(String word) {
            Trie.Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.childs[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.childs[ch - 'a'];
            }

            return curr.isEnd;
        }

        public boolean startsWith(String prefix) {
            Trie.Node curr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (curr.childs[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.childs[ch - 'a'];
            }

            return true;
        }

        static class Node {

            Trie.Node[] childs;
            boolean isEnd;

            Node() {
                childs = new Trie.Node[26];
                isEnd = false;
            }
        }
    }
}