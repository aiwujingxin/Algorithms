package basic.algorithm.np.tsp;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/26 22:30
 */

public class TSP_backtrack {

    public static int tsp(int[][] distance) {
        int N = distance.length;
        boolean[] visited = new boolean[N];
        visited[0] = true; // 将起始城市标记为已访问
        return backtrack(distance, visited, 0, 1, 0);
    }

    private static int backtrack(int[][] distance, boolean[] visited, int currCity, int count, int pathLength) {
        int N = distance.length;
        if (count == N) {
            // 所有城市都已经访问过，返回回到起始城市的路径长度
            return pathLength + distance[currCity][0];
        }

        int minPath = Integer.MAX_VALUE;
        for (int nextCity = 0; nextCity < N; nextCity++) {
            if (!visited[nextCity]) {
                visited[nextCity] = true;
                int newPathLength = pathLength + distance[currCity][nextCity];
                int currentPath = backtrack(distance, visited, nextCity, count + 1, newPathLength);
                minPath = Math.min(minPath, currentPath);
                visited[nextCity] = false; // 回溯，标记为未访问
            }
        }
        return minPath;
    }

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
}
