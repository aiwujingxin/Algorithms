package knowledge.algorithms.search.dfsAndBfs.dfs;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author wujingxinit@outlook.com
 * @date 5/27/25 02:46
 * @description IDDFS 通用的迭代加深深度优先搜索 (IDDFS) 求解器。
 */
public class IDDFS<T> {
    // --- 行为注入 ---
    private final Predicate<T> isGoal;
    private final Function<T, Collection<T>> getNeighbors;

    public IDDFS(Predicate<T> goalTest, Function<T, Collection<T>> successorFunc) {
        this.isGoal = goalTest;
        this.getNeighbors = successorFunc;
    }

    /**
     * 启动 IDDFS 搜索。
     *
     * @param start         初始状态。
     * @param maxIterations 最大迭代深度。
     * @return 最短路径列表，如果无解则返回 null。
     */
    public List<T> solve(T start, int maxIterations) {
        for (int maxDepth = 0; maxDepth < maxIterations; maxDepth++) {
            Deque<T> path = new LinkedList<>();
            if (dfs(path, start, 0, maxDepth)) {
                return new ArrayList<>(path);  // dfs 成功后，path 中就保存了完整的路径
            }
        }
        return null;
    }

    /**
     * 递归的、有界限的深度优先搜索。
     *
     * @return 如果在当前分支下找到解，则返回 true；否则返回 false。
     */
    private boolean dfs(Deque<T> path, T node, int depth, int maxDepth) {
        path.addLast(node);
        if (isGoal.test(node)) return true; // 找到目标
        if (depth >= maxDepth) {
            path.removeLast(); // 达到深度限制，回溯
            return false;
        }
        for (T neighbor : getNeighbors.apply(node)) {
            if (!path.contains(neighbor)) {
                if (dfs(path, neighbor, depth + 1, maxDepth)) {
                    return true; // 子路径找到了解，直接返回 true，不再回溯当前路径
                }
            }
        }
        path.removeLast(); // 所有邻居都无法通向目标，回溯
        return false;
    }
}