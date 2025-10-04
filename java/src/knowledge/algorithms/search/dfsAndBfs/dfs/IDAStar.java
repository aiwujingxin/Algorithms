package knowledge.algorithms.search.dfsAndBfs.dfs;

import knowledge.algorithms.search.dfsAndBfs.problems.EgyptianFraction_ida;
import knowledge.algorithms.search.dfsAndBfs.problems.EightPuzzle_ida;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 22:48
 * @description IDA* 是对迭代加深搜索 IDDFS 的优化. 适合状态空间爆炸、适合迭代加深策略的问题
 * g(n) + h(n) ≤ 当前阈值（threshold）
 * @see EgyptianFraction_ida    埃及分数
 * @see EightPuzzle_ida         八数码
 */
public class IDAStar<T> {
    // --- 行为注入 ---
    private final Function<T, Integer> h; // 启发函数 (h-value)
    private final Predicate<T> isGoal;    // 目标判断
    private final Function<T, Collection<T>> getNeighbors; // 后继生成

    public IDAStar(Function<T, Integer> heuristic, Predicate<T> goalTest, Function<T, Collection<T>> successorFunc) {
        this.h = heuristic;
        this.isGoal = goalTest;
        this.getNeighbors = successorFunc;
    }

    /**
     * 启动 IDA* 搜索。
     *
     * @param start 初始状态。
     * @return 最优路径列表，如果无解则返回 null。
     */
    public List<T> solve(T start) {
        int bound = h.apply(start);
        Deque<T> path = new LinkedList<>();
        while (true) {
            SearchResult<T> result = search(path, start, 0, bound);
            if (result.isSuccess()) {
                return result.path; // 成功找到解
            }
            if (result.nextBound == Integer.MAX_VALUE) {
                return null; // 搜索空间已耗尽，无解
            }
            bound = result.nextBound; // 更新 bound，开始新一轮迭代
        }
    }

    /**
     * 递归的、有界限的深度优先搜索。
     *
     * @param path  当前路径
     * @param node  当前节点/状态
     * @param g     从起点到当前节点的实际代价
     * @param bound 当前迭代的 f(n) 上限
     * @return SearchResult 对象，包含路径或下一轮的 bound。
     */
    private SearchResult<T> search(Deque<T> path, T node, int g, int bound) {
        path.addLast(node);
        try { // 使用 try-finally 确保 path.removeLast() 总能被执行
            int f = g + h.apply(node);
            if (f > bound) {
                return SearchResult.failure(f); // 剪枝，并返回新的 bound 候选
            }
            if (isGoal.test(node)) {
                return SearchResult.success(new ArrayList<>(path)); // 找到解
            }
            int minNextBound = Integer.MAX_VALUE;
            for (T neighbor : getNeighbors.apply(node)) {
                if (!path.contains(neighbor)) {
                    SearchResult<T> result = search(path, neighbor, g + 1, bound);
                    if (result.isSuccess()) {
                        return result; // 找到解，直接层层返回
                    }
                    minNextBound = Math.min(minNextBound, result.nextBound);
                }
            }
            return SearchResult.failure(minNextBound); // 返回当前分支下的最小 nextBound
        } finally {
            path.removeLast(); // 无论如何，退出当前递归层时都执行回溯
        }
    }

    // --- 内部辅助类，用于封装搜索结果 ---
    private record SearchResult<T>(List<T> path, int nextBound) {
        static <T> SearchResult<T> success(List<T> path) {
            return new SearchResult<>(path, -1);
        }

        static <T> SearchResult<T> failure(int nextBound) {
            return new SearchResult<>(null, nextBound);
        }

        boolean isSuccess() {
            return path != null;
        }
    }
}