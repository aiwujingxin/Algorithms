package leetcode.lists.LCP;

import java.util.Arrays;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/20 00:06
 */
public class LCP04 {

    //https://leetcode.cn/problems/broken-board-dominoes/solution/er-fen-tu-zui-da-pi-pei-xiong-ya-li-suan-fa-by-cha/

    public int domino(int n, int m, int[][] broken) {
        int tot = n * m;
        boolean[][] graph = new boolean[n][m];
        for (int[] p : broken) {
            graph[p[0]][p[1]] = true;
        }

        int[] match = new int[tot];
        Arrays.fill(match, -1);
        boolean[] visited = new boolean[tot];

        int res = 0;
        // loop all even points.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i + j) % 2 == 1 || graph[i][j]) {
                    continue;
                }
                Arrays.fill(visited, false);
                if (find(graph, match, visited, i, j)) {
                    res++;
                }
            }
        }

        return res;
    }

    // match the current even points with other odd points
    private boolean find(boolean[][] graph, int[] match, boolean[] visited, int x, int y) {
        int m = graph.length, n = graph[0].length;
        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        // check the connected odd points to (x,y);
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !graph[nx][ny]) {
                int index = nx * n + ny;
                if (visited[index]) {
                    continue;
                }
                visited[index] = true;
                if (match[index] == -1 || find(graph, match, visited, match[index] / n, match[index] % n)) {
                    match[index] = x * n + y;
                    return true;
                }
            }
        }
        return false;
    }
}
