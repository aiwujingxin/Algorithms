package knowledge.algorithms.search.dfsAndBfs.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.AStar;

import java.util.*;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 16:54
 */
public class EightPuzzle_astar3 {

    private static final int[] FACTORIAL = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};

    // --- 康托展开/逆康托展开/启发函数 辅助方法 ---
    private static int cantor(int[] state) {
        int result = 0;
        for (int i = 0; i < 9; i++) {
            int count = 0;
            for (int j = i + 1; j < 9; j++) {
                if (state[j] < state[i]) count++;
            }
            result += count * FACTORIAL[8 - i];
        }
        return result;
    }

    private static int[] decantor(int code) {
        int[] state = new int[9];
        boolean[] used = new boolean[10];
        for (int i = 0; i < 9; i++) {
            int r = code / FACTORIAL[8 - i];
            code %= FACTORIAL[8 - i];
            int k = 0;
            for (int j = 0; j <= 8; j++) {
                if (!used[j]) {
                    if (k == r) {
                        state[i] = j;
                        used[j] = true;
                        break;
                    }
                    k++;
                }
            }
        }
        return state;
    }

    private static int calculateManhattanDistance(int[] state) {
        int distance = 0;
        for (int i = 0; i < 9; i++) {
            int value = state[i];
            if (value != 0) {
                int targetIndex = value - 1;
                int currentX = i % 3, currentY = i / 3;
                int targetX = targetIndex % 3, targetY = targetIndex / 3;
                distance += Math.abs(currentX - targetX) + Math.abs(currentY - targetY);
            }
        }
        return distance;
    }

    private static boolean isSolvable(int[] state) {
        int inversions = 0;
        for (int i = 0; i < 9; i++) {
            if (state[i] == 0) continue;
            for (int j = i + 1; j < 9; j++) {
                if (state[j] != 0 && state[i] > state[j]) inversions++;
            }
        }
        return inversions % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] startArray = new int[9];
        String[] input = sc.nextLine().split(" ");
        for (int i = 0; i < 9; i++) {
            startArray[i] = input[i].equals("x") ? 0 : Integer.parseInt(input[i]);
        }
        sc.close();
        if (!isSolvable(startArray)) {
            System.out.println(-1);
            return;
        }
        // 状态 T 是 Integer (康托编码)
        Integer startState = cantor(startArray);
        Integer goalState = cantor(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 0});
        // 1. 定义 getNeighbors 函数
        Function<Integer, List<Map.Entry<Integer, Integer>>> getNeighbors = (currentCode) -> {
            List<Map.Entry<Integer, Integer>> neighbors = new ArrayList<>();
            int[] currentState = decantor(currentCode);
            int zeroIndex = -1;
            for (int i = 0; i < 9; i++) if (currentState[i] == 0) zeroIndex = i;
            int zx = zeroIndex % 3, zy = zeroIndex / 3;
            int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] d : DIR) {
                int nx = zx + d[1], ny = zy + d[0];
                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    int[] neighborArray = currentState.clone();
                    int neighborIndex = ny * 3 + nx;
                    neighborArray[zeroIndex] = neighborArray[neighborIndex];
                    neighborArray[neighborIndex] = 0;
                    neighbors.add(new AbstractMap.SimpleEntry<>(cantor(neighborArray), 1));
                }
            }
            return neighbors;
        };
        // 2. 定义 heuristic 函数
        // 注意：这里的第二个参数 endState (目标康托码) 实际上没用到，因为曼哈顿距离是和固定的目标棋盘比较
        BiFunction<Integer, Integer, Integer> heuristic = (currentCode, endCode) -> {
            int[] currentState = decantor(currentCode);
            return calculateManhattanDistance(currentState);
        };
        // 3. 创建 A* 实例并调用
        AStar<Integer> solver = new AStar<>();
        int steps = solver.search(startState, goalState, getNeighbors, heuristic);
        System.out.println(steps);
    }
}
