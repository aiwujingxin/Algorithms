package leetcode;

import basic.datastructure.advance.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/8/28 16:58
 */
public class LeetCode130_uf {

    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0) {
            return;
        }
        int cols = board[0].length;
        if (cols == 0) {
            return;
        }

        UnionFind unionFind = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;

        // 填写第 1 行和最后一行
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                unionFind.union(getIndex(0, j, cols), dummyNode);
            }
            if (board[rows - 1][j] == 'O') {
                unionFind.union(getIndex(rows - 1, j, cols), dummyNode);
            }
        }

        // 填写第 1 列和最后一列
        for (int i = 1; i < rows - 1; i++) {
            if (board[i][0] == 'O') {
                unionFind.union(getIndex(i, 0, cols), dummyNode);
            }
            if (board[i][cols - 1] == 'O') {
                unionFind.union(getIndex(i, cols - 1, cols), dummyNode);
            }
        }


        int[][] directions = new int[][]{{0, 1}, {1, 0}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        if (newX < rows && newY < cols && board[newX][newY] == 'O') {
                            unionFind.union(getIndex(i, j, cols), getIndex(newX, newY, cols));
                        }
                    }
                }
            }
        }

        for (int i = 1; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (board[i][j] == 'O') {
                    if (!unionFind.isConnected(getIndex(i, j, cols), dummyNode)) {
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }
}
