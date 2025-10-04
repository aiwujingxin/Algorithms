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
    private final Function<T, Integer> h;
    private final Predicate<T> isGoal;
    private final Function<T, Collection<T>> getNeighbors;
    private List<T> finalPath;

    public IDAStar(Function<T, Integer> heuristic, Predicate<T> goalTest, Function<T, Collection<T>> successorFunc) {
        this.h = heuristic;
        this.isGoal = goalTest;
        this.getNeighbors = successorFunc;
    }

    public List<T> solve(T start) {
        int bound = h.apply(start);
        while (finalPath == null) {
            int nextBound = search(new LinkedList<>(), start, 0, bound);
            if (nextBound == -1) return finalPath;           // 找到路径
            if (nextBound == Integer.MAX_VALUE) return null; // 搜索结束
            bound = nextBound;                               // 更新 bound
        }
        return null;                                         // 理论上不会执行到这里
    }

    private int search(Deque<T> path, T node, int g, int bound) {
        int f = g + h.apply(node);
        if (f > bound) return f;                        // 剪枝，返回新的 bound
        path.addLast(node);
        if (isGoal.test(node)) {
            finalPath = new ArrayList<>(path);          // 保存路径
            return -1;                                  // 成功信号
        }
        int minNextBound = Integer.MAX_VALUE;
        for (T neighbor : getNeighbors.apply(node)) {
            if (!path.contains(neighbor)) {             // 避免回头路
                int result = search(path, neighbor, g + 1, bound);
                if (result == -1) return -1;            // 找到路径
                minNextBound = Math.min(minNextBound, result); // 更新最小 bound
            }
        }
        path.removeLast(); // 回溯
        return minNextBound;
    }
}