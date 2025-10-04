package leetcode.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.AStar;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/3 02:00
 */
public class LeetCode752_astar {

    public int openLock(String[] deadends, String target) {
        String startState = "0000";
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains(startState)) return -1;
        // 1. 定义 getNeighbors 函数
        Function<String, List<Map.Entry<String, Integer>>> getNeighbors = (currentState) -> {
            List<Map.Entry<String, Integer>> neighbors = new ArrayList<>();
            char[] chars = currentState.toCharArray();
            for (int i = 0; i < 4; i++) {
                char originalChar = chars[i];
                int digit = originalChar - '0';
                // --- 向上转 ---
                chars[i] = (char) (((digit + 1) % 10) + '0');
                String neighborUp = new String(chars);
                if (!deadSet.contains(neighborUp)) {
                    neighbors.add(new AbstractMap.SimpleEntry<>(neighborUp, 1));
                }
                // (digit + 9) % 10 是一个避免负数取模的经典技巧，等价于 (digit - 1)
                chars[i] = (char) (((digit + 9) % 10) + '0');
                String neighborDown = new String(chars);
                if (!deadSet.contains(neighborDown)) {
                    neighbors.add(new AbstractMap.SimpleEntry<>(neighborDown, 1));
                }
                chars[i] = originalChar;
            }
            return neighbors;
        };
        // 2. 定义 heuristic 函数
        BiFunction<String, String, Integer> heuristic = (currentState, endState) -> {
            int totalDistance = 0;
            for (int i = 0; i < 4; i++) {
                int curDigit = currentState.charAt(i) - '0';
                int targetDigit = endState.charAt(i) - '0';
                int diff = Math.abs(curDigit - targetDigit);
                totalDistance += Math.min(diff, 10 - diff);
            }
            return totalDistance;
        };
        // 3. 创建 A* 实例并调用
        Integer res = new AStar().search(startState, target, getNeighbors, heuristic, 0, Integer::sum);
        return res == null ? -1 : res;
    }
}
