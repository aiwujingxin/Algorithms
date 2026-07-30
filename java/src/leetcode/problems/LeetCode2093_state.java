package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 01:45
 * @description 2093. 前往目标城市的最低费用
 */
public class LeetCode2093_state {

    public int minimumCost(int n, int[][] highways, int discounts) {
        List<List<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] highway : highways) {
            graph.get(highway[0]).add(new int[]{highway[1], highway[2]});
            graph.get(highway[1]).add(new int[]{highway[0], highway[2]});
        }

        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(city, used): 当前城市、已使用折扣次数。
            @Override
            public StateDijkstra.State start() {
                return new StateDijkstra.State(0, 0);
            }

            @Override
            public boolean isGoal(StateDijkstra.State s) {
                return s.at(0) == n - 1;
            }

            @Override
            public List<StateDijkstra.Edge> neighbors(StateDijkstra.State s) {
                int city = s.at(0), used = s.at(1);
                List<StateDijkstra.Edge> res = new ArrayList<>();
                for (int[] highway : graph.get(city)) {
                    int next = highway[0], toll = highway[1];
                    res.add(new StateDijkstra.Edge(new StateDijkstra.State(next, used), toll));
                    if (used < discounts) {
                        res.add(new StateDijkstra.Edge(
                                new StateDijkstra.State(next, used + 1),
                                toll / 2
                        ));
                    }
                }
                return res;
            }
        });
        return (int) ans;
    }
}
