package basic.algorithm.other.nphard.tsp;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/26 22:43
 * <a href="https://www.bilibili.com/video/BV1fY4y1e7JU/?spm_id_from=333.788.top_right_bar_window_history.content.click&vd_source=88e5a3e60377510439e11f13b5878c25">...</a>
 * <a href="https://www.bilibili.com/video/BV1KK411p72i/?spm_id_from=333.337.search-card.all.click&vd_source=88e5a3e60377510439e11f13b5878c25">...</a>
 */
public class TSP_Branch_Bound {

    public static void main(String[] args) {
        int[][] distance = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 60},
                {20, 25, 60, 0}
        };

        int shortestPath = tsp(distance);
        System.out.println("The shortest path length is: " + shortestPath);
    }

    public static int tsp(int[][] distance) {
        int N = distance.length;
        boolean[] visited = new boolean[N];
        visited[0] = true; // 将起始城市标记为已访问
        return branchAndBound(distance, visited, 0, 1, 0, Integer.MAX_VALUE);
    }

    private static int branchAndBound(int[][] distance, boolean[] visited, int currCity, int count, int pathLength, int bestPath) {
        int N = distance.length;
        if (count == N) {
            // 所有城市都已经访问过，返回回到起始城市的路径长度
            return pathLength + distance[currCity][0];
        }

        for (int nextCity = 0; nextCity < N; nextCity++) {
            if (!visited[nextCity]) {
                visited[nextCity] = true;
                int newPathLength = pathLength + distance[currCity][nextCity];

                // 计算当前路径长度与最优路径长度的下界
                int lowerBound = newPathLength + calculateLowerBound(distance, visited, nextCity);

                if (lowerBound < bestPath) {
                    int currentPath = branchAndBound(distance, visited, nextCity, count + 1, newPathLength, bestPath);
                    bestPath = Math.min(bestPath, currentPath);
                }

                visited[nextCity] = false; // 回溯，标记为未访问
            }
        }
        return bestPath;
    }

    private static int calculateLowerBound(int[][] distance, boolean[] visited, int currCity) {
        int N = distance.length;
        int lowerBound = 0;

        // 计算未访问城市到当前城市的最小距离和
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                int minDistance = Integer.MAX_VALUE;
                for (int j = 0; j < N; j++) {
                    if (i != j && visited[j]) {
                        minDistance = Math.min(minDistance, distance[i][j]);
                    }
                }
                lowerBound += minDistance;
            }
        }

        // 计算当前城市到起始城市的距离
        lowerBound += distance[currCity][0];

        return lowerBound;
    }
}
