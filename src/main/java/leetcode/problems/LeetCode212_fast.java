package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/6 22:27
 */
public class LeetCode212_fast {
    TrieNode root;
    char[][] board;
    int m, n;
    HashSet<String> set;
    private final int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        root = new TrieNode();
        set = new HashSet<>();
        this.board = board;

        for (String s : words) {
            insert(s);
        }

        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i, j, root, new StringBuilder());
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(int i, int j, TrieNode node, StringBuilder sb) {
        char c = board[i][j];
        if (node.next[c - 'a'] == null) {
            return;
        }
        if (node.next[c - 'a'].cnt == 0) {
            return;
        }

        sb.append(c);
        node = node.next[c - 'a'];
        board[i][j] = '#';

        if (node.isEnd) {
            set.add(sb.toString());
            remove(sb.toString());
            node.isEnd = false;
        }

        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }

            if (board[x][y] == '#') {
                continue;
            }
            dfs(x, y, node, sb);
        }
        sb.setLength(sb.length() - 1);
        board[i][j] = c;
    }

    private void remove(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            node = node.next[c - 'a'];
            node.cnt--;
        }
    }

    private void insert(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            if (node.next[c - 'a'] == null) {
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
            node.cnt++;
        }
        node.isEnd = true;
    }

    private static class TrieNode {
        private final TrieNode[] next;
        private boolean isEnd;
        private int cnt;

        public TrieNode() {
            this.next = new TrieNode[26];
            this.isEnd = false;
            this.cnt = 0;
        }
    }
}
