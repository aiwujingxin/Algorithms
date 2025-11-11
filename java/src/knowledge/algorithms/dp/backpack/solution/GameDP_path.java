package knowledge.algorithms.dp.backpack.solution;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 11/5/25 04:56
 */
public class GameDP_path {

    // 使用 Long[][] memo 进行记忆化搜索，避免重复计算
    private Long[][] memo;
    // 使用 HashMap<Point, Point> path 记录从一个点到下一个点的最优选择
    private HashMap<Point, Point> path;

    // 内部静态类 Point，用于表示坐标
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")"; // 修改为更常见的坐标格式
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    /**
     * 主函数，驱动整个流程
     *
     * @param grid 输入的网格
     */
    public void findAndPrintOptimalPath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            System.out.println("Grid is empty.");
            return;
        }
        int m = grid.length;
        int n = grid[0].length;
        this.memo = new Long[m][n];
        this.path = new HashMap<>();
        long maxScore = dfs(0, 0, grid);
        System.out.println("Maximum path score: " + maxScore);
        printOptimalPath(grid);
    }

    public long dfs(int i, int j, int[][] grid) {
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        long scoreFromDown = dfs(i + 1, j, grid);
        long scoreFromRight = dfs(i, j + 1, grid);
        if (scoreFromDown >= scoreFromRight) {
            path.put(new Point(i, j), new Point(i + 1, j));
        } else {
            path.put(new Point(i, j), new Point(i, j + 1));
        }
        long maxScore = grid[i][j] + Math.max(scoreFromDown, scoreFromRight);
        memo[i][j] = maxScore;
        return maxScore;
    }

    public void printOptimalPath(int[][] grid) {
        if (path == null || path.isEmpty()) {
            System.out.println("Path information not available.");
            return;
        }
        List<Point> optimalPath = new ArrayList<>();
        Point current = new Point(0, 0);
        // 从起点 (0,0) 开始，沿着 path 记录的路径前进，直到终点
        while (current != null) {
            optimalPath.add(current);
            if (current.x == grid.length - 1 && current.y == grid[0].length - 1) {
                break;
            }
            current = path.get(current);
        }
        System.out.println("Optimal Path:");
        StringBuilder pathString = new StringBuilder();
        for (int i = 0; i < optimalPath.size(); i++) {
            pathString.append(optimalPath.get(i).toString());
            if (i < optimalPath.size() - 1) {
                pathString.append(" -> ");
            }
        }
        System.out.println(pathString.toString());
    }

    public static void main(String[] args) {
        GameDP_path solver = new GameDP_path();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("Running on grid:");
        for (int[] row : grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------------");
        solver.findAndPrintOptimalPath(grid);
    }
}
