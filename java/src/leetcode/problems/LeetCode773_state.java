package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 03:10
 * @description 773. 滑动谜题
 */
public class LeetCode773_state {

    private static final int[][] NEXT = {
            {1, 3}, {0, 2, 4}, {1, 5},
            {0, 4}, {1, 3, 5}, {2, 4}
    };
    private static final int[] TARGET = {1, 2, 3, 4, 5, 0};

    public int slidingPuzzle(int[][] board) {
        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(c0, c1, ..., c5): 按行展开后的完整棋盘排列。
            @Override
            public StateDijkstra.State start() {
                return new StateDijkstra.State(
                        board[0][0], board[0][1], board[0][2],
                        board[1][0], board[1][1], board[1][2]
                );
            }

            @Override
            public boolean isGoal(StateDijkstra.State s) {
                for (int i = 0; i < TARGET.length; i++) {
                    if (s.at(i) != TARGET[i]) return false;
                }
                return true;
            }

            @Override
            public List<StateDijkstra.Edge> neighbors(StateDijkstra.State s) {
                int[] cells = new int[6];
                int zero = 0;
                for (int i = 0; i < cells.length; i++) {
                    cells[i] = s.at(i);
                    if (cells[i] == 0) zero = i;
                }

                List<StateDijkstra.Edge> res = new ArrayList<>(NEXT[zero].length);
                for (int next : NEXT[zero]) {
                    int[] nextCells = cells.clone();
                    nextCells[zero] = nextCells[next];
                    nextCells[next] = 0;
                    res.add(new StateDijkstra.Edge(new StateDijkstra.State(nextCells), 1));
                }
                return res;
            }
        });
        return (int) ans;
    }
}
