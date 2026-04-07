package leetcode.problems;

/**
 * @author wujingxinit@outlook.com
 * @date 8/25/25 23:50
 */
public class LeetCode885 {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = rStart, y = cStart;
        int[][] ans = new int[rows * cols][2];
        int step = 1;
        int index = 0;
        int d = 0;
        while (index < rows * cols) {
            for (int i = 0; i < step; i++) {
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    ans[index++] = new int[]{x, y};
                }
                x += dirs[d][0];
                y += dirs[d][1];
            }
            d = (d + 1) % 4;
            if (d % 2 == 0) {
                step++;
            }
        }
        return ans;
    }
}
