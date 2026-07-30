package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 00:48
 * @description 787. K 站中转内最便宜的航班
 */
public class LeetCode787_state {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            graph.computeIfAbsent(flight[0], key -> new ArrayList<>())
                    .add(new int[]{flight[1], flight[2]});
        }

        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(city, used): 当前城市、已使用的航班数。
            @Override
            public StateDijkstra.State start() {
                return new StateDijkstra.State(src, 0);
            }

            @Override
            public boolean isGoal(StateDijkstra.State s) {
                return s.at(0) == dst;
            }

            @Override
            public List<StateDijkstra.Edge> neighbors(StateDijkstra.State s) {
                List<StateDijkstra.Edge> res = new ArrayList<>();
                if (s.at(1) <= k) {
                    for (int[] e : graph.getOrDefault(s.at(0), List.of())) {
                        res.add(new StateDijkstra.Edge(new StateDijkstra.State(e[0], s.at(1) + 1), e[1]));
                    }
                }
                return res;
            }
        });
        return (int) ans;
    }
}
