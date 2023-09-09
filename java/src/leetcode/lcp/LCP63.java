package leetcode.lcp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/8 22:17
 */
public class LCP63 {

    public int[][] ballGame(int num, String[] plate) {
        int m = plate.length;
        int n = plate[0].length();
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[m][n][4];
        int d = 0;
        List<int[]> ans = new ArrayList<>();
        int[] ddr = new int[]{-1, 0, 1, 0};
        int[] ddc = new int[]{0, 1, 0, -1};
        for (int j = 1; j < n - 1; j++) {
            if (plate[0].charAt(j) == '.') {
                queue.offer(new int[]{0, j, 2, 0, j});
                visited[0][j][2] = true;
            }
            if (plate[m - 1].charAt(j) == '.') {
                queue.offer(new int[]{m - 1, j, 0, m - 1, j});
                visited[m - 1][j][0] = true;
            }
        }

        for (int i = 1; i < m - 1; i++) {
            if (plate[i].charAt(0) == '.') {
                queue.offer(new int[]{i, 0, 1, i, 0});
                visited[i][0][1] = true;
            }
            if (plate[i].charAt(n - 1) == '.') {
                queue.offer(new int[]{i, n - 1, 3, i, n - 1});
                visited[i][n - 1][3] = true;
            }
        }


        while (!queue.isEmpty()) {
            d++;
            if (d > num) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int dr = cur[2];
                int r, c, k;
                if (plate[x].charAt(y) == '.') {
                    r = x + ddr[dr];
                    c = y + ddc[dr];
                    k = dr;
                } else if (plate[x].charAt(y) == 'W') {
                    r = x - ddc[dr];
                    c = y + ddr[dr];
                    k = (dr + 3) % 4;
                } else {
                    r = x + ddc[dr];
                    c = y - ddr[dr];
                    k = (dr + 1) % 4;
                }

                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c][k]) {
                    if (plate[r].charAt(c) == 'O') {
                        ans.add(new int[]{cur[3], cur[4]});
                    } else {
                        visited[r][c][k] = true;
                        queue.addLast(new int[]{r, c, k, cur[3], cur[4]});
                    }
                }
            }
        }
        int[][] res = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);

        }
        return res;
    }
}
