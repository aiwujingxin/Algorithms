package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/10 23:20
 */
public class LeetCode54 {

    public int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int dir = 0;
        int x = 0;
        int y = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m * n; i++) {
            list.add(matrix[x][y]);
            matrix[x][y] = Integer.MAX_VALUE;
            int nx = x + dirs[dir][0];
            int ny = y + dirs[dir][1];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || matrix[nx][ny] == Integer.MAX_VALUE) {
                dir = (dir + 1) % 4;
            }
            x += dirs[dir][0];
            y += dirs[dir][1];
        }
        return list;
    }
}
