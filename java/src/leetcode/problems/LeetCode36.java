package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/9 18:11
 */
public class LeetCode36 {

    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9], cols = new int[9], boxes = new int[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int mask = 1 << (board[i][j] - '1');
                int bid = (i / 3) * 3 + (j / 3);
                if ((rows[i] & mask) != 0 || (cols[j] & mask) != 0 || (boxes[bid] & mask) != 0) {
                    return false;
                }
                rows[i] |= mask;
                cols[j] |= mask;
                boxes[bid] |= mask;
            }
        }
        return true;
    }
}
