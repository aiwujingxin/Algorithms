package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 03:10
 * @description 1654. 到家的最少跳跃次数
 */
public class LeetCode1654_state {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> blocked = new HashSet<>();
        int maxForbidden = 0;
        for (int position : forbidden) {
            blocked.add(position);
            maxForbidden = Math.max(maxForbidden, position);
        }
        if (blocked.contains(0)) return -1;

        int upperBound = Math.max(x, maxForbidden) + a + b;
        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(position, lastBackward): 当前坐标、上一步是否向后跳。
            @Override
            public StateDijkstra.State start() {
                return new StateDijkstra.State(0, 0);
            }

            @Override
            public boolean isGoal(StateDijkstra.State s) {
                return s.at(0) == x;
            }

            @Override
            public List<StateDijkstra.Edge> neighbors(StateDijkstra.State s) {
                int position = s.at(0), lastBackward = s.at(1);
                List<StateDijkstra.Edge> res = new ArrayList<>(2);

                int forward = position + a;
                if (forward <= upperBound && !blocked.contains(forward)) {
                    res.add(new StateDijkstra.Edge(new StateDijkstra.State(forward, 0), 1));
                }

                int backward = position - b;
                if (lastBackward == 0 && backward >= 0 && !blocked.contains(backward)) {
                    res.add(new StateDijkstra.Edge(new StateDijkstra.State(backward, 1), 1));
                }
                return res;
            }
        });
        return (int) ans;
    }
}
