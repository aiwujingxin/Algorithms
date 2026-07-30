package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 01:10
 * @description 864. 获取所有钥匙的最短路径
 */
public class LeetCode864_state {

    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        int startRow = 0, startCol = 0, fullMask = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i].charAt(j);
                if (ch == '@') {
                    startRow = i;
                    startCol = j;
                } else if (ch >= 'a' && ch <= 'f') {
                    fullMask |= 1 << (ch - 'a');
                }
            }
        }

        int sr = startRow, sc = startCol, targetMask = fullMask;
        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(row, col, mask): 行、列、已持有钥匙集合。
            @Override
            public StateDijkstra.State start() {
                return new StateDijkstra.State(sr, sc, 0);
            }

            @Override
            public boolean isGoal(StateDijkstra.State s) {
                return s.at(2) == targetMask;
            }

            @Override
            public List<StateDijkstra.Edge> neighbors(StateDijkstra.State s) {
                int row = s.at(0), col = s.at(1), mask = s.at(2);
                List<StateDijkstra.Edge> res = new ArrayList<>(4);
                for (int[] dir : DIRS) {
                    int nextRow = row + dir[0], nextCol = col + dir[1];
                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n) continue;

                    char ch = grid[nextRow].charAt(nextCol);
                    if (ch == '#') continue;
                    if (ch >= 'A' && ch <= 'F' && (mask & (1 << (ch - 'A'))) == 0) continue;

                    int nextMask = mask;
                    if (ch >= 'a' && ch <= 'f') {
                        nextMask |= 1 << (ch - 'a');
                    }
                    res.add(new StateDijkstra.Edge(new StateDijkstra.State(nextRow, nextCol, nextMask), 1));
                }
                return res;
            }
        });
        return (int) ans;
    }
}
