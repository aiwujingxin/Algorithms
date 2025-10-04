package knowledge.algorithms.search.dfsAndBfs.bfs;

import knowledge.algorithms.search.dfsAndBfs.problems.EightPuzzle_astar;
import knowledge.algorithms.search.dfsAndBfs.problems.MazeProblem;
import leetcode.problems.LeetCode752_astar;

import java.util.*;
import java.util.function.*;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 16:35
 * @description A*=BFS+贪心, 在图中查找从起点到终点的最优路径代价。
 * f(x)= g(x) + h(x). g(x)初始状态到x的实际代价, h(x)表示x到终点的最优路径评估。
 * 这是一个高度通用的实现，它通过泛型和函数式接口将算法的核心逻辑与具体的状态表示、代价类型和操作完全解耦。调用者需要提供状态的表示方式、代价的类型，以及如何计算代价、生成邻居等具体行为。
 * Dij是特殊的A*(代价函数=0)
 * @see MazeProblem
 * @see EightPuzzle_astar
 * @see LeetCode752_astar
 */
public class AStar {
    /**
     * @param <T> 状态的类型。可以是任何对象，例如坐标、棋盘布局或自定义状态类。
     * @param <C> 代价（权重）的类型。例如Integer, Double, 或自定义的数值类型。以便比较路径代价的优劣。
     * @param s   搜索的起始状态 (Start)。
     * @param e   搜索的目标状态 (End)。
     * @param n   邻居函数 (Neighbors)。输入一个状态，返回一个列表，Map.Entry}，包含邻居状态 及其对应的转移代价。
     * @param h   启发函数 (Heuristic)。一个双参数函数，输入当前状态 和目标状态，
     *            返回一个从当前状态到目标状态的估计代价。这是 A* 算法的核心。
     * @param z   代价类型的“零”值。由于泛型无法直接表示数值零，需要调用者显式提供。
     * @param a   代价类型的“加法”操作。一个二元操作符，定义了两个代价 如何相加。
     * @return 如果找到路径，则返回从起点到终点的最小总代价；如果不可达，则返回null。
     */
    public <T, C extends Comparable<C>> C search(T s, T e, Function<T, List<Map.Entry<T, C>>> n, BiFunction<T, T, C> h, C z, BinaryOperator<C> a) {
        Map<T, C> g = new HashMap<>();
        PriorityQueue<Map.Entry<T, C>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        g.put(s, z);
        pq.add(new AbstractMap.SimpleEntry<>(s, h.apply(s, e)));
        while (!pq.isEmpty()) {
            Map.Entry<T, C> cur = pq.poll();
            T u = cur.getKey();
            C cost = g.get(u);
            if (cost.compareTo(g.get(u)) > 0) {
                continue;
            }
            if (u.equals(e)) return cost;
            for (var v : n.apply(u)) {
                T next = v.getKey();
                C newCost = a.apply(cost, v.getValue());
                if (g.get(next) == null || newCost.compareTo(g.get(next)) < 0) {
                    g.put(next, newCost);
                    pq.add(new AbstractMap.SimpleEntry<>(next, a.apply(newCost, h.apply(next, e))));
                }
            }
        }
        return null;
    }

    /**
     * @author wujingxinit@outlook.com
     * @date 10/5/25 02:38
     */
    public static class H {
        // 曼哈顿距离 (4方向网格)
        public static final ToIntBiFunction<P, P> MANHATTAN = (a, b) -> Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());

        // 切比雪夫距离 (8方向网格，斜线代价==直走代价)
        public static final ToIntBiFunction<P, P> CHEBYSHEV = (a, b) -> Math.max(Math.abs(a.x() - b.x()), Math.abs(a.y() - b.y()));

        //欧几里得距离 (任意方向，返回 double)
        public static final ToDoubleBiFunction<P, P> EUCLIDEAN_D = (a, b) -> {
            double dx = a.x() - b.x();
            double dy = a.y() - b.y();
            return Math.sqrt(dx * dx + dy * dy);
        };
        // 欧几里得距离 (任意方向，返回 int)
        public static final ToIntBiFunction<P, P> EUCLIDEAN_I = (a, b) -> (int) EUCLIDEAN_D.applyAsDouble(a, b);

        // 汉明距离 (拼图：错位瓦片计数，忽略 '0' 或其他占位符)
        public static final ToIntBiFunction<String, String> HAMMING = (s, t) -> {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != t.charAt(i)) count++;
            }
            return count;
        };
        // 八数码的曼哈顿距离 ('0' 为空格；3x3)
        public static final ToIntBiFunction<String, String> PUZZLE_MANHATTAN = (s, t) -> {
            int distance = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '0') continue;
                int targetIndex = t.indexOf(c);
                // 计算当前位置 (i/3, i%3) 和目标位置 (j/3, j%3) 的曼哈顿距离
                distance += Math.abs(i / 3 - targetIndex / 3) + Math.abs(i % 3 - targetIndex % 3);
            }
            return distance;
        };

        // 需要用对象存储，因为数组对比是内存地址，Equal 方法会出错
        public record P(int x, int y) {
        }
    }
}