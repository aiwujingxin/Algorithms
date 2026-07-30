package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 01:45
 * @description 847. 访问所有节点的最短路径
 */
public class LeetCode847_state {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length, fullMask = (1 << n) - 1;
        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(node, mask): 当前节点、已访问节点集合；node=-1 表示零权虚拟起点。
            @Override
            public StateDijkstra.State start() {
                return new StateDijkstra.State(-1, 0);
            }

            @Override
            public boolean isGoal(StateDijkstra.State s) {
                return s.at(1) == fullMask;
            }

            @Override
            public List<StateDijkstra.Edge> neighbors(StateDijkstra.State s) {
                int node = s.at(0), mask = s.at(1);
                List<StateDijkstra.Edge> res = new ArrayList<>();
                if (node == -1) {
                    for (int i = 0; i < n; i++) {
                        res.add(new StateDijkstra.Edge(new StateDijkstra.State(i, 1 << i), 0));
                    }
                    return res;
                }

                for (int next : graph[node]) {
                    res.add(new StateDijkstra.Edge(
                            new StateDijkstra.State(next, mask | (1 << next)),
                            1
                    ));
                }
                return res;
            }
        });
        return (int) ans;
    }
}
