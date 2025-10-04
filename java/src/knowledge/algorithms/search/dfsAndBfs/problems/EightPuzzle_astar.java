package knowledge.algorithms.search.dfsAndBfs.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.AStar;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 9/18/25 16:54
 * @description 八数码 A* / 曼哈顿距离作为启发式函数 + 康托展开来检查状态是否已访问
 */
public class EightPuzzle_astar {

    public class Main {

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
            Integer steps = new AStar().search(startState, goalState, getNeighbors, heuristic, 0, Integer::sum);
            // 5. 输出结果
            System.out.println(steps == null ? "Impossible" : steps);
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

    public class astar_opt {

        private static final int[] FACTORIAL = {1, 1, 2, 6, 24, 120, 720, 5040, 40320};

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
            Integer steps = new AStar().search(startState, goalState, getNeighbors, heuristic, 0, Integer::sum);
            System.out.println(steps == null ? "Impossible" : steps);
        }

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
    }

    public class astar_opt_2 {

        static final int[] FACT = {1, 1, 2, 6, 24, 120, 720, 5040, 40320}; // 康托展开
        static final int LEN = 362880; // 9!
        static final int[][] DIR = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // 上左下右

        static int[] start = new int[9];
        static int[] goal = new int[9];
        static boolean[] visited = new boolean[LEN];

        static class Node {
            int[] state = new int[9];
            int dis;

            Node(int[] s, int d) {
                System.arraycopy(s, 0, state, 0, 9);
                dis = d;
            }
        }

        static int cantor(int[] state) {
            int result = 0;
            for (int i = 0; i < 9; i++) {
                int count = 0;
                for (int j = i + 1; j < 9; j++) {
                    if (state[i] > state[j]) count++;
                }
                result += count * FACT[8 - i];
            }
            return result;
        }

        static boolean isGoal(int[] state) {
            return Arrays.equals(state, goal);
        }

        public static int bfs() {
            Queue<Node> queue = new LinkedList<>();
            int code = cantor(start);
            visited[code] = true;
            queue.offer(new Node(start, 0));

            while (!queue.isEmpty()) {
                Node cur = queue.poll();

                if (isGoal(cur.state)) return cur.dis;

                int zero = 0;
                for (; zero < 9; zero++) {
                    if (cur.state[zero] == 0) break;
                }

                int x = zero % 3;
                int y = zero / 3;

                for (int[] d : DIR) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    int nz = ny * 3 + nx;

                    if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                        int[] newState = cur.state.clone();
                        // swap zero and target
                        int tmp = newState[zero];
                        newState[zero] = newState[nz];
                        newState[nz] = tmp;

                        int hash = cantor(newState);
                        if (!visited[hash]) {
                            visited[hash] = true;
                            queue.offer(new Node(newState, cur.dis + 1));
                        }
                    }
                }
            }
            return -1; // Impossible
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            for (int i = 0; i < 9; i++) start[i] = sc.nextInt();
            for (int i = 0; i < 9; i++) goal[i] = sc.nextInt();

            int ans = bfs();
            System.out.println(ans != -1 ? ans : "Impossible");
        }
    }
}
