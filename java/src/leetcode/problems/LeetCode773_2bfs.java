package leetcode.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.BiBFS;

import java.util.*;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 14:20
 */
public class LeetCode773_2bfs {

    // 预计算每个位置可以交换的邻居索引
    // 棋盘布局:
    // 0 1 2
    // 3 4 5
    private final int[][] neighborsMap = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        // 1. 定义 start 和 end 状态
        String startState = boardToString(board);
        String endState = "123450";
        // 2. 定义状态转移函数 (getNeighbors)
        Function<String, List<String>> getNeighbors = (currentState) -> {
            List<String> nextStates = new ArrayList<>();
            // a. 找到 '0' 的位置
            int zeroIndex = currentState.indexOf('0');
            // b. 遍历 '0' 的所有可交换邻居
            for (int neighborIndex : neighborsMap[zeroIndex]) {
                // c. 生成新状态字符串
                String nextState = swap(currentState, zeroIndex, neighborIndex);
                nextStates.add(nextState);
            }
            return nextStates;
        };
        // 3. 创建 BiBFS 实例并调用
        BiBFS<String> bfs = new BiBFS<>();
        return bfs.search(startState, endState, getNeighbors);
    }

    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
