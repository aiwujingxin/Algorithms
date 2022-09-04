package leetCode.problems;


import java.util.ArrayList;
import java.util.List;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/7/6 22:28
 */
public class LeetCode212_fastest {
    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for (String word : words) {
            addWord(word, root);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                process(board, i, j, root, ans);
            }
        }
        return ans;
    }

    int process(char[][] board, int i, int j, Node cur, List<String> ans) {
        if (board[i][j] == 0) {
            return 0;
        }
        char c = board[i][j];
        int index = c - 'a';
        if (cur.nexts[index] == null || cur.nexts[index].pass == 0) {
            return 0;
        }
        int count = 0;
        cur = cur.nexts[index];
        if (cur.end != null) {
            ans.add(cur.end);
            cur.end = null;
            count++;
        }
        board[i][j] = 0;
        if (i < board.length - 1) {
            count += process(board, i + 1, j, cur, ans);
        }
        if (i > 0) {
            count += process(board, i - 1, j, cur, ans);
        }
        if (j > 0) {
            count += process(board, i, j - 1, cur, ans);
        }
        if (j < board[0].length - 1) {
            count += process(board, i, j + 1, cur, ans);
        }
        board[i][j] = c;
        cur.pass -= count;
        return count;
    }

    void addWord(String word, Node root) {
        Node cur = root;
        cur.pass++;
        char[] sc = word.toCharArray();
        for (char c : sc) {
            int index = c - 'a';
            if (cur.nexts[index] == null) {
                cur.nexts[index] = new Node();
            }
            cur = cur.nexts[index];
            cur.pass++;
        }
        cur.end = word;
    }

    class Node {
        Node[] nexts = new Node[26];
        int pass = 0;
        String end;
    }
}



