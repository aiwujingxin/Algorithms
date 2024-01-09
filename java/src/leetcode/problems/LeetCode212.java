package leetcode.problems;



import knowledge.datastructure.trie.Trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/6 22:17
 */
public class LeetCode212 {

    Set<String> res = new HashSet<>();
    Trie trie = new Trie();

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(board, visited, "", i, j);
            }
        }

        return new ArrayList<>(res);
    }

    public void backtrack(char[][] board, boolean[][] visited, String str, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y]) {
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
        backtrack(board, visited, str, x - 1, y);
        backtrack(board, visited, str, x + 1, y);
        backtrack(board, visited, str, x, y - 1);
        backtrack(board, visited, str, x, y + 1);
        visited[x][y] = false;
    }
}
