package leetcode.problems;

import knowledge.datastructure.graph.shortestpath.impl.StateDijkstra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 03:10
 * @description 752. 打开转盘锁
 */
public class LeetCode752_state {

    public int openLock(String[] deadends, String target) {
        Set<Integer> blocked = new HashSet<>();
        for (String deadend : deadends) {
            blocked.add(Integer.parseInt(deadend));
        }
        if (blocked.contains(0)) return -1;

        int targetCode = Integer.parseInt(target);
        long ans = StateDijkstra.solve(new StateDijkstra.Problem() {
            // State(d0, d1, d2, d3): 转盘从高位到低位的四个数字。
            @Override
            public StateDijkstra.State start() {
                return new StateDijkstra.State(0, 0, 0, 0);
            }

            @Override
            public boolean isGoal(StateDijkstra.State s) {
                return encode(s) == targetCode;
            }

            @Override
            public List<StateDijkstra.Edge> neighbors(StateDijkstra.State s) {
                int[] digits = {s.at(0), s.at(1), s.at(2), s.at(3)};
                List<StateDijkstra.Edge> res = new ArrayList<>(8);
                for (int i = 0; i < 4; i++) {
                    int original = digits[i];

                    digits[i] = (original + 1) % 10;
                    addIfAllowed(digits, blocked, res);

                    digits[i] = (original + 9) % 10;
                    addIfAllowed(digits, blocked, res);

                    digits[i] = original;
                }
                return res;
            }
        });
        return (int) ans;
    }

    private void addIfAllowed(int[] digits, Set<Integer> blocked, List<StateDijkstra.Edge> edges) {
        int code = encode(digits);
        if (!blocked.contains(code)) {
            edges.add(new StateDijkstra.Edge(new StateDijkstra.State(digits[0], digits[1], digits[2], digits[3]), 1));
        }
    }

    private int encode(StateDijkstra.State s) {
        return ((s.at(0) * 10 + s.at(1)) * 10 + s.at(2)) * 10 + s.at(3);
    }

    private int encode(int[] digits) {
        return ((digits[0] * 10 + digits[1]) * 10 + digits[2]) * 10 + digits[3];
    }
}
