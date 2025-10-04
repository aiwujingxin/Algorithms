package knowledge.algorithms.search.dfsAndBfs.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.AStar;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 11:48
 * @description A*=BFS+贪心, f(x)= g(x) + h(x). g(x)初始状态到x的实际代价, h(x)表示x到终点的最优路径评估。Dij是特殊的A*(代价函数=0)
 * 时间复杂度: O(E)
 */
public class MazeProblem_astar {
    // 0:上，1:右，2:下，3:左
    public static int[] move = new int[]{-1, 0, 1, 0, -1};

    // Dijkstra算法
    // grid[i][j] == 0 代表障碍
    // grid[i][j] == 1 代表道路
    // 只能走上、下、左、右，不包括斜线方向
    // 返回从(startX, startY)到(targetX, targetY)的最短距离
    public static int minDistance1(int[][] grid, int startX, int startY, int targetX, int targetY) {
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
        distance[startX][startY] = 1;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        // 0 : 行
        // 1 : 列
        // 2 : 从源点出发到达当前点的距离
        heap.add(new int[]{startX, startY, 1});
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int x = cur[0];
            int y = cur[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            if (x == targetX && y == targetY) {
                return distance[x][y];
            }
            for (int i = 0, nx, ny; i < 4; i++) {
                nx = x + move[i];
                ny = y + move[i + 1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1 && !visited[nx][ny]
                        && distance[x][y] + 1 < distance[nx][ny]) {
                    distance[nx][ny] = distance[x][y] + 1;
                    heap.add(new int[]{nx, ny, distance[x][y] + 1});
                }
            }
        }
        return -1;
    }

    /**
     * 使用 A* 算法计算网格中的最短距离。
     * 状态由 int[]{x, y} 数组表示。
     *
     * @param grid    二维网格，1 表示可通行，0 表示障碍物。
     * @param startX  起点 x 坐标。
     * @param startY  起点 y 坐标。
     * @param targetX 终点 x 坐标。
     * @param targetY 终点 y 坐标。
     * @return 最短距离，如果不可达则返回 -1。
     */
    public static int minDistance(int[][] grid, int startX, int startY, int targetX, int targetY) {
        // 检查起点和终点是否有效
        if (grid[startX][startY] == 0 || grid[targetX][targetY] == 0) {
            return -1;
        }
        // 1. 使用 int[] 数组表示起点和终点
        int[] start = new int[]{startX, startY};
        int[] end = new int[]{targetX, targetY};
        int n = grid.length;
        int m = grid[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        // 2. 定义 getNeighbors，输入和输出都使用 int[]
        Function<int[], List<Map.Entry<int[], Integer>>> getNeighbors = (current) -> {
            List<Map.Entry<int[], Integer>> neighbors = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                int newX = current[0] + dx[i];
                int newY = current[1] + dy[i];
                if (newX >= 0 && newX < n && newY >= 0 && newY < m && grid[newX][newY] == 1) {
                    // 每个邻居的移动代价为 1
                    neighbors.add(new AbstractMap.SimpleEntry<>(new int[]{newX, newY}, 1));
                }
            }
            return neighbors;
        };
        // 3. 定义 heuristic，输入为 int[]
        // (可以直接使用我们之前定义的 Heuristic.MANHATTAN)
        BiFunction<int[], int[], Integer> heuristic = (current, goal) ->
                Math.abs(current[0] - goal[0]) + Math.abs(current[1] - goal[1]);
        // 4. 创建 AStar<int[]> 实例并调用
        // 注意：AStar 算法的实现必须能正确处理数组的 equals 和 hashCode
        AStar<int[]> solver = new AStar<>();
        // A* 返回的是边的数量（即步数），如果需要返回节点数量，则需要 +1
        return solver.search(start, end, getNeighbors, heuristic);
    }

    // A*算法
    // grid[i][j] == 0 代表障碍
    // grid[i][j] == 1 代表道路
    // 只能走上、下、左、右，不包括斜线方向
    // 返回从(startX, startY)到(targetX, targetY)的最短距离
    public static int minDistance2(int[][] grid, int startX, int startY, int targetX, int targetY) {
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
        distance[startX][startY] = 1;
        boolean[][] visited = new boolean[n][m];
        // 0 : 行
        // 1 : 列
        // 2 : 从源点出发到达当前点的距离 + 当前点到终点的预估距离
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        heap.add(new int[]{startX, startY, 1 + f1(startX, startY, targetX, targetY)});
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int x = cur[0];
            int y = cur[1];
            if (visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            if (x == targetX && y == targetY) {
                return distance[x][y];
            }
            for (int i = 0, nx, ny; i < 4; i++) {
                nx = x + move[i];
                ny = y + move[i + 1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 1 && !visited[nx][ny]
                        && distance[x][y] + 1 < distance[nx][ny]) {
                    distance[nx][ny] = distance[x][y] + 1;
                    heap.add(new int[]{nx, ny, distance[x][y] + 1 + f1(nx, ny, targetX, targetY)});
                }
            }
        }
        return -1;
    }

    // 曼哈顿距离
    public static int f1(int x, int y, int targetX, int targetY) {
        return (Math.abs(targetX - x) + Math.abs(targetY - y));
    }

    // 对角线距离
    public static int f2(int x, int y, int targetX, int targetY) {
        return Math.max(Math.abs(targetX - x), Math.abs(targetY - y));
    }

    // 欧式距离
    public static double f3(int x, int y, int targetX, int targetY) {
        return Math.sqrt(Math.pow(targetX - x, 2) + Math.pow(targetY - y, 2));
    }

    // 为了测试
    public static int[][] randomGrid(int n) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.random() < 0.3) {
                    // 每个格子有30%概率是0
                    grid[i][j] = 0;
                } else {
                    // 每个格子有70%概率是1
                    grid[i][j] = 1;
                }
            }
        }
        return grid;
    }

    // 为了测试
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
            int ans1 = minDistance1(grid, startX, startY, targetX, targetY);
            int ans2 = minDistance2(grid, startX, startY, targetX, targetY);
            if (ans1 != ans2) {
                System.out.println("出错了!");
            }
        }
        System.out.println("功能测试结束");
        System.out.println("性能测试开始");
        int[][] grid = randomGrid(4000);
        int startX = 0;
        int startY = 0;
        int targetX = 3900;
        int targetY = 3900;
        long start, end;
        start = System.currentTimeMillis();
        int ans1 = minDistance1(grid, startX, startY, targetX, targetY);
        end = System.currentTimeMillis();
        System.out.println("运行dijskra算法结果: " + ans1 + ", 运行时间(毫秒) : " + (end - start));
        start = System.currentTimeMillis();
        int ans2 = minDistance2(grid, startX, startY, targetX, targetY);
        end = System.currentTimeMillis();
        System.out.println("运行A*算法结果: " + ans2 + ", 运行时间(毫秒) : " + (end - start));
        System.out.println("性能测试结束");
    }
}
