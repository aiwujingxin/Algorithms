package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 03:10
 * @description 1263. 推箱子
 */
public class LeetCode1263_state {

    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minPushBox(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int boxRow = 0, boxCol = 0, playerRow = 0, playerCol = 0;
        int targetRow = 0, targetCol = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'B') {
                    boxRow = i;
                    boxCol = j;
                } else if (grid[i][j] == 'S') {
                    playerRow = i;
                    playerCol = j;
                } else if (grid[i][j] == 'T') {
                    targetRow = i;
                    targetCol = j;
                }
            }
        }

        int br = boxRow, bc = boxCol, pr = playerRow, pc = playerCol;
        int tr = targetRow, tc = targetCol;
        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(boxRow, boxCol, playerRow, playerCol): 箱子位置、玩家位置。
            @Override
            public StateDijkstra.State start() {
                return new StateDijkstra.State(br, bc, pr, pc);
            }

            @Override
            public boolean isGoal(StateDijkstra.State s) {
                return s.at(0) == tr && s.at(1) == tc;
            }

            @Override
            public List<StateDijkstra.Edge> neighbors(StateDijkstra.State s) {
                int curBoxRow = s.at(0), curBoxCol = s.at(1);
                int curPlayerRow = s.at(2), curPlayerCol = s.at(3);
                List<StateDijkstra.Edge> res = new ArrayList<>(4);
                for (int[] dir : DIRS) {
                    int nextPlayerRow = curPlayerRow + dir[0];
                    int nextPlayerCol = curPlayerCol + dir[1];
                    if (!valid(nextPlayerRow, nextPlayerCol, grid)) continue;

                    if (nextPlayerRow == curBoxRow && nextPlayerCol == curBoxCol) {
                        int nextBoxRow = curBoxRow + dir[0];
                        int nextBoxCol = curBoxCol + dir[1];
                        if (!valid(nextBoxRow, nextBoxCol, grid)) continue;
                        res.add(new StateDijkstra.Edge(
                                new StateDijkstra.State(
                                        nextBoxRow, nextBoxCol,
                                        curBoxRow, curBoxCol
                                ),
                                1
                        ));
                    } else {
                        res.add(new StateDijkstra.Edge(
                                new StateDijkstra.State(
                                        curBoxRow, curBoxCol,
                                        nextPlayerRow, nextPlayerCol
                                ),
                                0
                        ));
                    }
                }
                return res;
            }
        });
        return (int) ans;
    }

    private boolean valid(int row, int col, char[][] grid) {
        return row >= 0 && row < grid.length
                && col >= 0 && col < grid[0].length
                && grid[row][col] != '#';
    }
}
