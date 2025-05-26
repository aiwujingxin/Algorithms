package knowledge.algorithms.search.dfsAndBfs.dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/6 22:48
 * @description IDA* 是对迭代加深搜索 IDDFS 的优化. 适合状态空间爆炸、适合迭代加深策略的问题
 * g(n) + h(n) ≤ 当前阈值（threshold）
 * 求解组合类问题、路径规划、推箱子、魔方、埃及分数、Power Calculus
 */

public class IDAStar {

    static String start = "起始状态";
    static String goal = "目标状态";

    // 初始阈值 = 启发函数(start)
    public static void main(String[] args) {
        int threshold = heuristic(start);
        while (true) {
            int t = dfs(start, 0, threshold, new HashSet<>());
            if (t == -1) {
                System.out.println("已找到目标，最小代价: " + threshold);
                break;
            }
            if (t == Integer.MAX_VALUE) {
                System.out.println("无解");
                break;
            }
            threshold = t;  // 提升阈值，继续深搜
        }
    }

    /**
     * IDA* 的 DFS 遍历
     *
     * @param state     当前状态
     * @param g         当前代价
     * @param threshold 当前阈值 f=g+h
     * @param visited   用于防止环路
     * @return -1 表示找到目标；否则返回下一个建议的 threshold
     */
    static int dfs(String state, int g, int threshold, Set<String> visited) {
        int f = g + heuristic(state);
        if (f > threshold) {
            return f;
        }
        if (state.equals(goal)) {
            return -1;
        }
        visited.add(state);
        int minNextThreshold = Integer.MAX_VALUE;
        for (String next : getNextStates(state)) {
            if (visited.contains(next)) {
                continue;
            }
            int t = dfs(next, g + 1, threshold, visited);
            if (t == -1) {
                return -1;
            }
            minNextThreshold = Math.min(minNextThreshold, t);
        }

        visited.remove(state); // 回溯
        return minNextThreshold;
    }

    // 启发函数（需具体实现，如曼哈顿距离）
    static int heuristic(String state) {
        return 0; // 例如：八数码曼哈顿距离
    }

    // 状态扩展函数（根据问题定义）
    static List<String> getNextStates(String state) {
        // 根据题目定义扩展状态
        return new ArrayList<>();
    }
}
