package knowledge.datastructure.graph.shortestpath.impl;

import leetcode.problems.*;
import leetcode.problems.lists.lcp.LCP35_state;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 7/31/26 00:37
 * @description 通用状态 Dijkstra 模板
 * <适用场景>
 * 普通最短路只用“位置”标识节点;当后续决策还受层数、时间、电量、次数、钥匙集合等资源影响时,
 * 必须将这些资源一起并入状态,把原问题转换为扩展图上的非负权最短路。
 * <统一建模>
 * 1. State(位置,资源1,资源2,...):扩展图中的节点,全部坐标共同参与 equals/hashCode。
 * 2. Edge(next,w):扩展图中的有向边,表示执行一次合法决策后到达 next,新增代价为 w。
 * 3. dist[state]:起点到完整状态的最短距离,相同位置但资源不同的状态分别记录。
 * 4. Problem:题目只需提供 start / isGoal / neighbors 三个钩子,主循环永久复用。
 * <执行链路>
 * 1. 起点以距离 0 入堆。
 * 2. 每次弹出当前代价最小的状态;若记录中已有更短距离,说明它是过期节点,直接跳过。
 * 3. 状态弹出且未过期时距离正式定稿;此时命中目标即可返回全局最优解。
 * 4. 枚举 neighbors 并执行松弛,只把距离严格变小的新状态重新入堆。
 * <正确性>
 * - 完整状态去重:位置相同但资源不同,后续可行转移不同,不能合并。
 * - 非负权定稿:所有 w>=0 时,堆顶是尚未定稿状态中的最小距离,后续路径不可能再改善它。
 * - 目标提前结束:必须在“弹出且确认未过期”后判断目标,不能在状态生成或入堆时直接返回。
 * <复杂度>
 * 设实际可达状态数为 S、这些状态产生的转移数为 T:
 * 时间 O((S+T)logS),空间 O(S+T);复杂度取决于扩展后的状态图,而不是原图的节点数。
 * <使用约束>
 * - 所有转移权重必须非负;存在负权边时应使用 Bellman-Ford/SPFA。
 * - State 各维的顺序与含义必须在题目中保持一致,资源变化统一写在 neighbors 中。
 * - 模板按完整状态精确去重,不自动执行“同位置下资源更优且代价更小”的支配剪枝。
 * - 多源问题可增加零权虚拟起点,由虚拟起点连接全部真实起点。
 * <题型映射>
 * @see LeetCode787_state State(city,usedEdges)
 * @see LeetCode2093_state State(city,usedDiscounts)
 * @see LeetCode1928_state State(city,time)
 * @see LeetCode864_state State(row,col,keyMask)
 * @see LeetCode1293_state State(row,col,remaining)
 * @see LeetCode847_state State(node,visitedMask)
 * @see LeetCode1263_state State(boxRow,boxCol,playerRow,playerCol)
 * @see LeetCode1654_state State(position,lastBackward)
 * @see LeetCode403_state State(stoneIndex,lastJump)
 * @see LeetCode752_state State(d0,d1,d2,d3)
 * @see LeetCode773_state State(c0,c1,...,c5)
 * @see LeetCode505_state State(row,col)
 * @see LCP35_state State(city,power)
 * @see "2953.cpp 飞行路线:State(city,freeCount)"
 */
public class StateDijkstra {

    private StateDijkstra() {
    }

    /**
     * 扩展图中的一条状态转移。
     *
     * @param next 转移后的完整状态
     * @param w    本次转移新增的非负代价
     */
    public record Edge(State next, long w) {
    }

    /**
     * 题目与通用 Dijkstra 主循环之间的适配接口。
     */
    public interface Problem {

        /**
         * 提供搜索的唯一初始状态。
         *
         * @return 搜索起点的完整状态
         */
        State start();

        /**
         * 判断当前完整状态是否属于目标状态集合。
         *
         * @param s 当前已定稿状态
         * @return 当前状态是否满足题目目标
         */
        boolean isGoal(State s);

        /**
         * 枚举当前状态可以执行的全部合法转移。
         *
         * @param s 当前完整状态
         * @return 从当前状态出发的非负权边
         */
        List<Edge> neighbors(State s);
    }

    /**
     * 在题目隐式定义的状态图上执行堆优化 Dijkstra。
     *
     * @param p 提供起点、目标判定和邻接转移的题目适配器
     * @return 起点到任一目标状态的最短距离，不可达时返回 -1
     */
    public static long solve(Problem p) {
        Map<State, Long> dist = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        State start = p.start();
        dist.put(start, 0L);
        pq.offer(new Node(start, 0L));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            long cost = cur.cost();
            State state = cur.state();

            if (cost > dist.getOrDefault(state, Long.MAX_VALUE)) continue;
            if (p.isGoal(state)) return cost;

            for (Edge e : p.neighbors(state)) {
                long nd = cost + e.w();
                if (nd < dist.getOrDefault(e.next(), Long.MAX_VALUE)) {
                    dist.put(e.next(), nd);
                    pq.offer(new Node(e.next(), nd));
                }
            }
        }
        return -1;
    }

    private record Node(State state, long cost) implements Comparable<Node> {

        @Override
        public int compareTo(Node other) {
            return Long.compare(cost, other.cost);
        }
    }

    /**
     * @author wujingxinit@outlook.com
     * @date 7/31/26 00:39
     * @description 通用多维状态
     * 坐标数量与每一维的含义由具体题目决定,例如:
     * - State(city,usedEdges)
     * - State(city,time)
     * - State(row,col,keyMask)
     * equals/hashCode 按全部坐标内容计算,保证 HashMap 以完整状态为键。
     * 若直接传入现成 int[] 数组,构造后不得再修改数组内容,否则会破坏哈希一致性。
     */
    public static final class State {

        private final int[] coordinates;

        /**
         * 创建一个由任意个整型坐标组成的完整状态。
         *
         * @param coordinates 按题目约定顺序排列的各维坐标
         */
        public State(int... coordinates) {
            this.coordinates = coordinates;
        }

        /**
         * 读取状态的指定维度。
         *
         * @param dimension 维度下标,从 0 开始
         * @return 指定维度的坐标值
         */
        public int at(int dimension) {
            return coordinates[dimension];
        }

        @Override
        public boolean equals(Object o) {
            return this == o || o instanceof State state && Arrays.equals(coordinates, state.coordinates);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(coordinates);
        }
    }
}
