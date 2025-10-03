package leetcode.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.BiBFS;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 14:29
 */
public class LeetCode2571_2bfs {

    public int minOperations(int n) {
        // 1. 定义 start 和 end 状态
        long startState = n;
        long endState = 0L;
        // 2. 定义剪枝边界
        // 一个经验上稳妥且有效的上界，防止状态无限增长
        long upperBound = 2L * n;
        // 3. 定义状态转移函数 (getNeighbors)
        Function<Long, List<Long>> getNeighbors = (currentNum) -> {
            List<Long> nextStates = new ArrayList<>();
            // 遍历所有可能的2的幂
            for (long p = 1; p <= upperBound; p <<= 1) {
                // 生成两个邻居：加法和减法
                long neighborAdd = currentNum + p;
                long neighborSub = currentNum - p;
                // 剪枝：只考虑在合理范围内的邻居
                if (neighborAdd >= 0 && neighborAdd <= upperBound) {
                    nextStates.add(neighborAdd);
                }
                if (neighborSub >= 0 && neighborSub <= upperBound) {
                    nextStates.add(neighborSub);
                }
                // 另一个剪枝：如果 p 已经比 currentNum 大很多，
                // currentNum - p 会是负数，currentNum + p 可能也超了，可以提前终止
                if (p > currentNum && p > upperBound - currentNum) {
                    break;
                }
            }
            return nextStates;
        };
        BiBFS<Long> bfs = new BiBFS<>();
        return bfs.search(startState, endState, getNeighbors);
    }
}
