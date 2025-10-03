package leetcode.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.BiBFS;

import java.util.*;
import java.util.HashSet;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/6/3 02:03
 */
public class LeetCode752_2bfs {

    public int openLock(String[] deadends, String target) {
        String startState = "0000";
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains(startState)) {
            return -1;
        }
        Function<String, List<String>> getNeighbors = (currentState) -> {
            List<String> neighbors = new ArrayList<>();
            char[] chars = currentState.toCharArray(); // 只创建一次字符数组
            for (int i = 0; i < 4; i++) {
                char originalChar = chars[i]; // 保存当前位的原始字符
                // --- 向上转 ---
                chars[i] = (char) (((originalChar - '0' + 1) % 10) + '0');
                String neighborUp = new String(chars);
                if (!deadSet.contains(neighborUp)) {
                    neighbors.add(neighborUp);
                }

                // --- 向下转 ---
                chars[i] = (char) (((originalChar - '0' + 9) % 10) + '0');
                String neighborDown = new String(chars);
                if (!deadSet.contains(neighborDown)) {
                    neighbors.add(neighborDown);
                }
                // --- 恢复原始字符 ---
                // 确保对下一位的修改是基于原始状态的
                chars[i] = originalChar;
            }
            return neighbors;
        };
        BiBFS<String> bfs = new BiBFS<>();
        return bfs.search(startState, target, getNeighbors);
    }
}
