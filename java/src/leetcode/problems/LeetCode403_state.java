package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 03:10
 * @description 403. 青蛙过河
 */
public class LeetCode403_state {

    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(stones[i], i);
        }

        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(stoneIndex, lastJump): 当前石头下标、上一次跳跃距离。
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
                int stoneIndex = s.at(0), lastJump = s.at(1);
                List<StateDijkstra.Edge> res = new ArrayList<>(3);
                for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {
                    if (jump <= 0) continue;
                    Integer nextIndex = index.get(stones[stoneIndex] + jump);
                    if (nextIndex != null) {
                        res.add(new StateDijkstra.Edge(
                                new StateDijkstra.State(nextIndex, jump),
                                1
                        ));
                    }
                }
                return res;
            }
        });
        return ans != -1;
    }
}
