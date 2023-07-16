package basic.algorithm.np.tsp;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/26 22:33
 */
public class TSP_greedy {
    public static int tsp(int[][] distance) {
        int N = distance.length;
        boolean[] visited = new boolean[N];
        visited[0] = true; // 将起始城市标记为已访问
        int currCity = 0; // 当前城市
        int pathLength = 0; // 路径长度

        for (int count = 1; count < N; count++) {
            int nextCity = getNextCity(distance, visited, currCity);
            visited[nextCity] = true;
            pathLength += distance[currCity][nextCity];
            currCity = nextCity;
        }

        // 回到起始城市
        pathLength += distance[currCity][0];
        return pathLength;
    }

    private static int getNextCity(int[][] distance, boolean[] visited, int currCity) {
        int N = distance.length;
        int nextCity = -1;
        int minDistance = Integer.MAX_VALUE;

        for (int city = 0; city < N; city++) {
            if (!visited[city] && distance[currCity][city] < minDistance) {
                minDistance = distance[currCity][city];
                nextCity = city;
            }
        }

        return nextCity;
    }

    public static void main(String[] args) {
        int[][] distance = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };
        int shortestPath = tsp(distance);
        System.out.println("The shortest path length is: " + shortestPath);
    }
}
