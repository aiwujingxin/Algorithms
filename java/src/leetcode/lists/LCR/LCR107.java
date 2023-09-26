package leetcode.lists.LCR;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/26 14:25
 */
public class LCR107 {

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[][]{};
        }
        int[][] res = new int[mat.length][mat[0].length];
        HashSet<String> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    int[] node = new int[]{i, j};
                    queue.add(node);
                    set.add(i + "," + j);
                }
            }
        }
        int step = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                for (int[] dir : dirs) {
                    int nx = node[0] + dir[0];
                    int ny = node[1] + dir[1];
                    if (nx < 0 || ny < 0 || nx >= mat.length || ny >= mat[0].length) {
                        continue;
                    }
                    if (set.contains(nx + "," + ny)) {
                        continue;
                    }
                    set.add(nx + "," + ny);
                    if (mat[nx][ny] == 1) {
                        res[nx][ny] = step + 1;
                    }
                    queue.add(new int[]{nx, ny});
                }
            }
            step++;
        }
        return res;
    }
}
