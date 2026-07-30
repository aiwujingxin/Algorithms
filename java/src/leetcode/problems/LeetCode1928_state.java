package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 01:10
 * @description 1928. 规定时间内到达终点的最小花费
 */
public class LeetCode1928_state {

    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<List<int[]>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(city, time): 当前城市、已使用时间。
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
                int city = s.at(0), time = s.at(1);
                List<StateDijkstra.Edge> res = new ArrayList<>();
                for (int[] edge : graph.get(city)) {
                    int nextTime = time + edge[1];
                    if (nextTime <= maxTime) {
                        res.add(new StateDijkstra.Edge(
                                new StateDijkstra.State(edge[0], nextTime),
                                passingFees[edge[0]]
                        ));
                    }
                }
                return res;
            }
        });
        return ans == -1 ? -1 : (int) (ans + passingFees[0]);
    }
}
