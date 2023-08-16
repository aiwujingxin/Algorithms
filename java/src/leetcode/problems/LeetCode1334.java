package leetcode.problems;

import java.util.Arrays;

/**
 * @author aiwujingxin@gmail.com
 * @date 2022/6/25 10:20
 */
public class LeetCode1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // build graph
        int[][] dis = new int[n][n];
        int res = 0, smallest = n;
        for (int[] row : dis) {
            Arrays.fill(row, 10001);
        }
        for (int[] e : edges) {
            dis[e[0]][e[1]] = dis[e[1]][e[0]] = e[2];
        }
        for (int i = 0; i < n; ++i) {
            dis[i][i] = 0;
        }

        // floyd
        for (int k = 0; k < n; ++k) {

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; ++j) {
                if (dis[i][j] <= distanceThreshold) {
                    ++count;
                }
            }
            if (count <= smallest) {
                res = i;
                smallest = count;
            }
        }
        return res;
    }
}
