package leetcode.topinterview;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/7 00:14
 */
public class LeetCode348 {

    class TicTacToe {
        /**
         * 矩阵大小
         */
        private final int n;
        /**
         * rows[i]=第i行之和
         */
        private final int[] rows;
        /**
         * cols[j]=第j列之和
         */
        private final int[] cols;
        /**
         * 对角线的和
         */
        private int dia1, dia2;

        public TicTacToe(int n) {
            this.n = n;
            rows = new int[n];
            cols = new int[n];
            dia1 = 0;
            dia2 = 0;
        }

        /**
         * 每一步放置棋子
         * 时间复杂度O(1)
         */
        public int Move(int row, int col, int player) {
            // 玩家下棋值
            int cell = 1 == player ? 1 : -1;
            // 玩家赢时和
            int sum = 1 == player ? n : -n;
            // 此行当前和
            rows[row] += cell;
            if (sum == rows[row]) {
                return player;
            }

            // 此列当前和
            cols[col] += cell;
            if (sum == cols[col]) {
                return player;
            }

            // 主对角线当前和
            if (row == col) {
                dia1 += cell;
                if (sum == dia1) {
                    return player;
                }

            }
            // 副对角线当前和
            if (row + col == n - 1) {
                dia2 += cell;
                if (sum == dia2) {
                    return player;
                }
            }
            return 0;
        }
    }
}
