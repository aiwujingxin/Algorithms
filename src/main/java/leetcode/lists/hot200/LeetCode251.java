package leetcode.lists.hot200;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/8 18:44
 */
public class LeetCode251 {

    class Vector2D {
        int row;
        int col;
        int[][] vec;

        public Vector2D(int[][] vec) {
            this.vec = vec;
        }

        public int next() {
            if (!this.hasNext()) {
                return -1;
            }
            int nextRow = row;
            if (col == this.vec[row].length) {
                while (nextRow < this.vec.length) {
                    nextRow++;
                    if (nextRow < this.vec.length && this.vec[nextRow].length > 0) {
                        break;
                    }
                }
                col = 0;
            }

            row = nextRow;
            int val = vec[row][col];
            col++;
            return val;
        }

        public boolean hasNext() {
            if (row == this.vec.length) {
                return false;
            }
            int nextRow = row;
            if (col == this.vec[row].length) {
                while (nextRow < this.vec.length) {
                    nextRow++;
                    if (nextRow < this.vec.length && this.vec[nextRow].length > 0) {
                        break;
                    }
                }
            }
            if (nextRow == this.vec.length) {
                return false;
            }
            return true;
        }
    }
}
