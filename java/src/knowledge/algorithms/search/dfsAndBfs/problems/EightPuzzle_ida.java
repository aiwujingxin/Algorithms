package knowledge.algorithms.search.dfsAndBfs.problems;

import knowledge.algorithms.search.dfsAndBfs.dfs.IDAStar;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author wujingxinit@outlook.com
 * @date 10/4/25 22:45
 */
public class EightPuzzle_ida {

    // 所有问题相关的配置都作为静态常量放在 Main 类中
    private static final String GOAL_BOARD = "12345678x";
    private static final int N = 3;
    private static final Map<Character, int[]> GOAL_POSITIONS = new HashMap<>();

    // 静态初始化块，用于预计算目标位置
    static {
        for (int i = 0; i < GOAL_BOARD.length(); i++) {
            GOAL_POSITIONS.put(GOAL_BOARD.charAt(i), new int[]{i / N, i % N});
        }
    }

    public static void main(String[] args) {
        // 1. 读取输入，直接生成初始状态字符串
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            String token = sc.next();
            sb.append(token.equals("0") ? "x" : token);
        }
        String initialState = sb.toString();
        if (!isSolvable(initialState)) {
            System.out.println(-1);
            return;
        }
        // 2. 定义所有行为逻辑为 Lambda 表达式，操作对象是 String
        // 启发函数: Function<String, Integer>
        Function<String, Integer> heuristicFunc = board -> {
            int sum = 0;
            for (int i = 0; i < board.length(); i++) {
                char c = board.charAt(i);
                if (c == 'x') continue;
                int[] goal = GOAL_POSITIONS.get(c);
                sum += Math.abs(i / N - goal[0]) + Math.abs(i % N - goal[1]);
            }
            return sum;
        };
        // 目标判断谓词: Predicate<String>
        List<String> solutionPath = getStrings(heuristicFunc, initialState);
        // --- 4. 处理并打印结果 ---
        if (solutionPath != null) {
            // 代价通过路径列表的大小计算
            int cost = solutionPath.size() - 1;
            System.out.println(cost);
            System.out.println("完整路径:");
            for (String board : solutionPath) {
                printBoard(board);
                System.out.println("---");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static List<String> getStrings(Function<String, Integer> heuristicFunc, String initialState) {
        Predicate<String> goalPredicate = board -> board.equals(GOAL_BOARD);
        // 后继生成函数: Function<String, Collection<String>>
        Function<String, Collection<String>> successorsFunc = board -> {
            Collection<String> successors = new LinkedList<>();
            int idx = board.indexOf('x');
            int x = idx / N, y = idx % N;
            int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : DIRS) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    char[] chars = board.toCharArray();
                    char temp = chars[idx];
                    chars[idx] = chars[nx * N + ny];
                    chars[nx * N + ny] = temp;
                    successors.add(new String(chars));
                }
            }
            return successors;
        };

        // --- 3. 创建并运行 IDA* 求解器 ---
        IDAStar<String> solver = new IDAStar<>(heuristicFunc, goalPredicate, successorsFunc);
        return solver.solve(initialState);
    }

    // isSolvable 方法保持不变
    private static boolean isSolvable(String s) {
        int inversions = 0;
        String sWithoutX = s.replace("x", "");
        for (int i = 0; i < sWithoutX.length(); i++) {
            for (int j = i + 1; j < sWithoutX.length(); j++) {
                if (sWithoutX.charAt(i) > sWithoutX.charAt(j)) {
                    inversions++;
                }
            }
        }
        return inversions % 2 == 0;
    }

    /**
     * 辅助函数，用于格式化打印棋盘状态。
     */
    private static void printBoard(String board) {
        for (int i = 0; i < board.length(); i++) {
            System.out.print(board.charAt(i) + " ");
            if ((i + 1) % N == 0) {
                System.out.println();
            }
        }
    }
}