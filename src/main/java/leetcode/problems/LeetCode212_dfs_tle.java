package leetcode.problems;

import java.util.*;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/6 21:34
 */
public class LeetCode212_dfs_tle {

    public static void main(String[] args) {
        System.out.println(new LeetCode212_dfs_tle().findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}));

        System.out.println(new LeetCode212_dfs_tle().findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcd"}));
    }

    public List<String> findWords(char[][] board, String[] words) {

        if (board == null || board.length == 0) {
            return new ArrayList<>();
        }

        HashSet<String> set = new HashSet<>();
        for (String word : words) {

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        if (dfs(board, i, j, word, 0, set, new boolean[board.length][board[0].length])) {
                            set.add(word);
                            break;
                        }

                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index, HashSet<String> set, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || word.charAt(index) != board[i][j]) {
            return false;
        }

        visited[i][j] = true;
        boolean found = dfs(board, i + 1, j, word, index + 1, set, visited) ||
                dfs(board, i - 1, j, word, index + 1, set, visited) ||
                dfs(board, i, j + 1, word, index + 1, set, visited) ||
                dfs(board, i, j - 1, word, index + 1, set, visited);

        visited[i][j] = false;


        return found;
    }
}
