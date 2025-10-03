package leetcode.problems;

import java.util.*;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 13:53
 */
public class LeetCode773 {
    // 预计算每个位置可以交换的邻居索引
    // 0 1 2
    // 3 4 5
    private final int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        // 1. 将二维数组状态转换为字符串
        String startState = boardToString(board);
        String targetState = "123450";
        // 边界情况：初始状态即为目标状态
        if (startState.equals(targetState)) {
            return 0;
        }
        // 2. 初始化双向BFS的数据结构
        Queue<String> qStart = new ArrayDeque<>();
        Map<String, Integer> distStart = new HashMap<>();
        Queue<String> qEnd = new ArrayDeque<>();
        Map<String, Integer> distEnd = new HashMap<>();
        // 3. 设置起点和终点
        qStart.offer(startState);
        distStart.put(startState, 0);
        qEnd.offer(targetState);
        distEnd.put(targetState, 0);
        // 4. 主循环
        while (!qStart.isEmpty() && !qEnd.isEmpty()) {
            int result;
            // 启发式优化：总是扩展节点数较少的一侧
            if (qStart.size() <= qEnd.size()) {
                result = expandLayer(qStart, distStart, distEnd);
            } else {
                result = expandLayer(qEnd, distEnd, distStart);
            }
            if (result != -1) {
                return result;
            }
        }
        return -1; // 无解
    }

    /**
     * 从队列中取出一层节点进行扩展
     */
    private int expandLayer(Queue<String> q, Map<String, Integer> distThis, Map<String, Integer> distOther) {
        int levelSize = q.size();
        for (int i = 0; i < levelSize; i++) {
            String current = q.poll();
            int currentDist = distThis.get(current);
            // 找到 '0' 的位置
            int zeroIndex = current.indexOf('0');
            // 遍历 '0' 的所有可交换邻居
            for (int neighborIndex : neighbors[zeroIndex]) {
                String nextState = swap(current, zeroIndex, neighborIndex);
                // 检查是否与另一侧相遇
                if (distOther.containsKey(nextState)) {
                    return currentDist + 1 + distOther.get(nextState);
                }
                // 如果是本侧未访问过的新状态，则入队
                if (!distThis.containsKey(nextState)) {
                    distThis.put(nextState, currentDist + 1);
                    q.offer(nextState);
                }
            }
        }
        return -1; // 本层未相遇
    }

    /**
     * 将二维数组棋盘转换为字符串
     */
    private String boardToString(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    /**
     * 在字符串中交换两个位置的字符
     */
    private String swap(String s, int i, int j) {
        char[] chars = s.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
