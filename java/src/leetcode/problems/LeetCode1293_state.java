package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 01:10
 * @description 1293. 网格中的最短路径
 */
public class LeetCode1293_state {

    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(row, col, remaining): 行、列、剩余障碍消除次数。
            @Override
            public StateDijkstra.State start() {
                return new StateDijkstra.State(0, 0, k);
            }

            @Override
            public boolean isGoal(StateDijkstra.State s) {
                return s.at(0) == m - 1 && s.at(1) == n - 1;
            }

            @Override
            public List<StateDijkstra.Edge> neighbors(StateDijkstra.State s) {
                int row = s.at(0), col = s.at(1), remaining = s.at(2);
                List<StateDijkstra.Edge> res = new ArrayList<>(4);
                for (int[] dir : DIRS) {
                    int nextRow = row + dir[0], nextCol = col + dir[1];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) continue;

                    int nextRemaining = remaining - grid[nextRow][nextCol];
                    if (nextRemaining >= 0) {
                        res.add(new StateDijkstra.Edge(new StateDijkstra.State(nextRow, nextCol, nextRemaining), 1));
                    }
                }
                return res;
            }
        });
        return (int) ans;
    }
}
