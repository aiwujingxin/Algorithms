package leetcode.problems.lists.lcp;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 01:10
 * @description LCP 35. 电动车游城市
 */
public class LCP35_state {

    public int electricCarPlan(int[][] paths, int cnt, int start, int end, int[] charge) {
        int n = charge.length;
        List<List<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] path : paths) {
            graph.get(path[0]).add(new int[]{path[1], path[2]});
            graph.get(path[1]).add(new int[]{path[0], path[2]});
        }

        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(city, power): 当前城市、当前电量。
            @Override
            public StateDijkstra.State start() {
                return new StateDijkstra.State(start, 0);
            }

            @Override
            public boolean isGoal(StateDijkstra.State s) {
                return s.at(0) == end;
            }

            @Override
            public List<StateDijkstra.Edge> neighbors(StateDijkstra.State s) {
                int city = s.at(0), power = s.at(1);
                List<StateDijkstra.Edge> res = new ArrayList<>();
                if (power < cnt) {
                    res.add(new StateDijkstra.Edge(new StateDijkstra.State(city, power + 1), charge[city]));
                }
                for (int[] edge : graph.get(city)) {
                    if (power >= edge[1]) {
                        res.add(new StateDijkstra.Edge(
                                new StateDijkstra.State(edge[0], power - edge[1]),
                                edge[1]
                        ));
                    }
                }
                return res;
            }
        });
        return (int) ans;
    }
}
