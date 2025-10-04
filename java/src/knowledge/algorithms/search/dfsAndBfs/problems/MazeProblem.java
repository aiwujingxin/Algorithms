package knowledge.algorithms.search.dfsAndBfs.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.AStar;

import java.util.*;
import java.util.function.Function;

import static knowledge.algorithms.search.dfsAndBfs.bfs.AStar.H.MANHATTAN;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 11:48
 * @description 迷宫
 * grid[i][j]中0障碍1道路 只能走上下左右，返回从(startX, startY)到(targetX, targetY)的最短距离
 */
public class MazeProblem {

    final static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int minDistance_astar(int[][] grid, int startX, int startY, int targetX, int targetY) {
        if (grid[startX][startY] == 0 || grid[targetX][targetY] == 0) {
            return -1;
        }
        AStar.H.P start = new AStar.H.P(startX, startY);
        AStar.H.P end = new AStar.H.P(targetX, targetY);
        int n = grid.length;
        int m = grid[0].length;
        Function<AStar.H.P, List<Map.Entry<AStar.H.P, Integer>>> getNeighbors = (cur) -> {
            List<Map.Entry<AStar.H.P, Integer>> neighbors = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x() + dirs[i][0];
                int ny = cur.y() + dirs[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1) {
                    neighbors.add(new AbstractMap.SimpleEntry<>(new AStar.H.P(nx, ny), 1));
                }
            }
            return neighbors;
        };
        Integer result = new AStar().search(start, end, getNeighbors, MANHATTAN::applyAsInt, 0, Integer::sum);
        return result == null ? -1 : result;
    }

    public static int minDistance_dij(int[][] grid, int startX, int startY, int targetX, int targetY) {
        if (grid[startX][startY] == 0 || grid[targetX][targetY] == 0) {
            return -1;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[startX][startY] = 0;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        heap.add(new int[]{startX, startY, 0});
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int x = cur[0];
            int y = cur[1];
            if (visited[x][y]) continue;
            visited[x][y] = true;
            if (x == targetX && y == targetY) return distance[x][y];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1 && !visited[nx][ny] && distance[x][y] + 1 < distance[nx][ny]) {
                    distance[nx][ny] = distance[x][y] + 1;
                    heap.add(new int[]{nx, ny, distance[x][y] + 1});
                }
            }
        }
        return -1;
    }

    // 测试
    public static void main(String[] args) {
        int len = 100;
        int testTime = 10000;
        System.out.println("功能测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * len) + 2;
            int[][] grid = randomGrid(n);
            int startX = (int) (Math.random() * n);
            int startY = (int) (Math.random() * n);
            int targetX = (int) (Math.random() * n);
            int targetY = (int) (Math.random() * n);
            int ans1 = minDistance_dij(grid, startX, startY, targetX, targetY);
            int ans2 = minDistance_astar(grid, startX, startY, targetX, targetY);
            if (ans1 != ans2) {
                System.out.println("出错了!");
            }
        }
        System.out.println("功能测试结束");
        System.out.println("性能测试开始");
        int[][] grid = randomGrid(8000);
        int startX = 0;
        int startY = 0;
        int targetX = 5900;
        int targetY = 6900;
        long start, end;
        start = System.currentTimeMillis();
        int ans1 = minDistance_dij(grid, startX, startY, targetX, targetY);
        end = System.currentTimeMillis();
        System.out.println("运行dijskra算法结果: " + ans1 + ", 运行时间(毫秒) : " + (end - start));
        start = System.currentTimeMillis();
        int ans2 = minDistance_astar(grid, startX, startY, targetX, targetY);
        end = System.currentTimeMillis();
        System.out.println("运行A*算法结果: " + ans2 + ", 运行时间(毫秒) : " + (end - start));
        System.out.println("性能测试结束");
    }

    public static int[][] randomGrid(int n) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.random() < 0.2) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = 1;
                }
            }
        }
        return grid;
    }
}

