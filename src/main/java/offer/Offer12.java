package offer;

/**
 * @author jingxinwu
 * @date 2021-11-21 1:07 下午
 */
public class Offer12 {

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0) {
            return false;
        }

        if (word == null || word.length() == 0) {
            return true;
        }

        // 遍历整个二维数组，即将每个字符作为第一个字符进行尝试
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 只要有一条符合条件，则返回true
                if (helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, String word, int row, int col, int index) {

        // 超过二维数组边界就返回false
        // 字符不匹配也直接结束递归
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
                board[row][col] != word.charAt(index)) {
            return false;
        }

        // 如果以及全部匹配到了，就直接返回true，而不用继续匹配剩下的啦
        if (index == word.length() - 1) {
            return true;
        }
        board[row][col] = '\0';
        boolean res = helper(board, word, row + 1, col, index + 1) ||
                helper(board, word, row - 1, col, index + 1) ||
                helper(board, word, row, col + 1, index + 1) ||
                helper(board, word, row, col - 1, index + 1);

        // 回溯的时候要把原来设置为空白字符的还原
        board[row][col] = word.charAt(index);
        return res;
    }

}
