package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 03:10
 * @description 505. 迷宫 II
 */
public class LeetCode505_state {

    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(row, col): 球当前停止的位置。
            @Override
            public StateDijkstra.State start() {
                return new StateDijkstra.State(start[0], start[1]);
            }

            @Override
            public boolean isGoal(StateDijkstra.State s) {
                return s.at(0) == destination[0] && s.at(1) == destination[1];
            }

            @Override
            public List<StateDijkstra.Edge> neighbors(StateDijkstra.State s) {
                int row = s.at(0), col = s.at(1);
                List<StateDijkstra.Edge> res = new ArrayList<>(4);
                for (int[] dir : DIRS) {
                    int nextRow = row, nextCol = col, distance = 0;
                    while (valid(nextRow + dir[0], nextCol + dir[1], maze, m, n)) {
                        nextRow += dir[0];
                        nextCol += dir[1];
                        distance++;
                    }
                    if (distance > 0) {
                        res.add(new StateDijkstra.Edge(
                                new StateDijkstra.State(nextRow, nextCol),
                                distance
                        ));
                    }
                }
                return res;
            }
        });
        return (int) ans;
    }

    private boolean valid(int row, int col, int[][] maze, int m, int n) {
        return row >= 0 && row < m && col >= 0 && col < n && maze[row][col] == 0;
    }
}
