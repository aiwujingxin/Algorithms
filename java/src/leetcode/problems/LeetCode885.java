package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/25/25 23:50
 */
public class LeetCode885 {

    public int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int x = rStart, y = cStart;
        int index = 0, step = 1;
        int[][] ans = new int[rows * cols][2];
        ans[index++] = new int[]{x, y};
        while (index < rows * cols) {
            for (int d = 0; d < 4; d++) {
                for (int i = 0; i < step; i++) {
                    x += dirs[d][0];
                    y += dirs[d][1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        ans[index++] = new int[]{x, y};
                    }
                }
                if (d % 2 == 1) {
                    step++;
                }
            }
        }
        return ans;
    }
}
