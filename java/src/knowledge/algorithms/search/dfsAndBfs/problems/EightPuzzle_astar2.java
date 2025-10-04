package knowledge.algorithms.search.dfsAndBfs.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.AStar;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 16:54
 */
public class EightPuzzle_astar2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        // 将输入的 "x" 替换为 "0"，并移除所有空格
        String startState = line.replace("x", "0").replaceAll("\\s+", "");
        // 目标状态
        String goalState = "123456780";
        // 1. 检查可解性
        if (!isSolvable(startState)) {
            System.out.println(-1);
            sc.close();
            return;
        }
        // 2. 定义 getNeighbors 函数
        Function<String, List<Map.Entry<String, Integer>>> getNeighbors = (currentState) -> {
            List<Map.Entry<String, Integer>> neighbors = new ArrayList<>();
            int zeroIndex = currentState.indexOf('0');
            int x = zeroIndex % 3;
            int y = zeroIndex / 3;
            int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上, 下, 左, 右
            for (int[] d : DIR) {
                int newY = y + d[0];
                int newX = x + d[1];
                if (newX >= 0 && newX < 3 && newY >= 0 && newY < 3) {
                    char[] chars = currentState.toCharArray();
                    int newIndex = newY * 3 + newX;
                    // 交换 '0' 和邻居
                    chars[zeroIndex] = chars[newIndex];
                    chars[newIndex] = '0';
                    String neighborState = new String(chars);
                    int cost = 1; // 每次移动成本为1
                    neighbors.add(new AbstractMap.SimpleEntry<>(neighborState, cost));
                }
            }
            return neighbors;
        };
        // 3. 定义 heuristic 函数 (曼哈顿距离)
        BiFunction<String, String, Integer> heuristic = (currentState, endState) -> {
            int manhattanDistance = 0;
            for (int i = 0; i < 9; i++) {
                char c = currentState.charAt(i);
                if (c != '0') {
                    int goalIndex = endState.indexOf(c);
                    // 计算当前位置 (i) 和目标位置 (goalIndex) 的曼哈顿距离
                    int currentX = i % 3, currentY = i / 3;
                    int goalX = goalIndex % 3, goalY = goalIndex / 3;
                    manhattanDistance += Math.abs(currentX - goalX) + Math.abs(currentY - goalY);
                }
            }
            return manhattanDistance;
        };
        // 4. 创建 A* 实例并调用
        AStar<String> solver = new AStar<>();
        int steps = solver.search(startState, goalState, getNeighbors, heuristic);
        // 5. 输出结果
        System.out.println(steps);
        sc.close();
    }

    /**
     * 检查八数码问题是否有解。
     * 通过计算两个状态的逆序对数量，如果它们的奇偶性相同，则有解。
     */
    private static boolean isSolvable(String start) {
        // 移除 '0' (空格) 后再计算逆序对
        int inversions = 0;
        String s = start.replace("0", "");
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) > s.charAt(j)) {
                    inversions++;
                }
            }
        }
        // 对于 3x3 的情况，逆序对为偶数才有解
        return inversions % 2 == 0;
    }
}
