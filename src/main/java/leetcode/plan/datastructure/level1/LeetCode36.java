package leetcode.plan.datastructure.level1;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/9 21:50
 */
public class LeetCode36 {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return true;
        }
        // row
        for (char[] chars : board) {
            if (!checkRow(chars)) {
                return false;
            }
        }
        // col
        for (int i = 0; i < board[0].length; i++) {
            if (!checkCol(board, i)) {
                return false;
            }
        }
        // m
        for (int i = 0; i < board.length; i = i + 3) {
            for (int j = 0; j < board[0].length; j = j + 3) {
                if (!checkMat(board, i, j)) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean checkMat(char[][] board, int startRow, int startCol) {
        HashSet<Character> set = new HashSet<>();

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        return true;
    }


    private boolean checkCol(char[][] board, int col) {
        HashSet<Character> set = new HashSet<>();
        for (char[] chars : board) {
            if (chars[col] == '.') {
                continue;
            }
            if (set.contains(chars[col])) {
                return false;
            }
            set.add(chars[col]);
        }
        return true;
    }

    private boolean checkRow(char[] chars) {
        HashSet<Character> set = new HashSet<>();
        for (char aChar : chars) {
            if (aChar == '.') {
                continue;
            }
            if (set.contains(aChar)) {
                return false;
            }
            set.add(aChar);
        }
        return true;
    }
}
