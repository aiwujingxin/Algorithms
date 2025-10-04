package knowledge.algorithms.search.dfsAndBfs.problems;

import knowledge.algorithms.search.dfsAndBfs.dfs.IDDFS;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author wujingxinit@outlook.com
 * @date 10/4/25 23:40
 */
public class EightPuzzle_iddfs {

    // --- 问题相关的静态配置 ---
    private static final String GOAL_BOARD = "12345678x";
    private static final int N = 3;

    public static void main(String[] args) {
        // --- 1. 读取和准备输入数据 ---
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("请输入八数码的初始状态 (用 'x' 或 '0' 代表空格，用空格或换行分隔):");
        for (int i = 0; i < 9; i++) {
            String token = sc.next();
            sb.append(token.equals("0") ? "x" : token);
        }
        String initialState = sb.toString();
        // 判断可解性
        if (!isSolvable(initialState)) {
            System.out.println("此八数码问题无解。");
            return;
        }
        // --- 2. 定义行为逻辑 ---
        // 目标判断谓词: Predicate<String>
        // 判断当前棋盘状态是否等于目标状态
        Predicate<String> goalPredicate = board -> board.equals(GOAL_BOARD);
        // 后继生成函数: Function<String, Collection<String>>
        // 生成当前棋盘状态下，空格可以移动到的所有新状态
        Function<String, Collection<String>> successorsFunction = board -> {
            Collection<String> successors = new LinkedList<>();
            int idx = board.indexOf('x');
            int r = idx / N; // 空格的行
            int c = idx % N; // 空格的列
            // 定义四个移动方向：上、下、左、右
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int newR = r + dr[i];
                int newC = c + dc[i];
                // 检查新位置是否在 3x3 网格内
                if (newR >= 0 && newR < N && newC >= 0 && newC < N) {
                    char[] chars = board.toCharArray();
                    // 交换空格和相邻的数字
                    char temp = chars[idx];
                    chars[idx] = chars[newR * N + newC];
                    chars[newR * N + newC] = temp;
                    successors.add(new String(chars));
                }
            }
            return successors;
        };
        // --- 3. 创建并配置 IDDFS 求解器 ---
        // 这里的泛型是 <String>
        IDDFS<String> solver = new IDDFS<>(goalPredicate, successorsFunction);
        // --- 4. 求解并打印结果 ---
        // 对于八数码，深度可能较深，设置一个合理的迭代上限，如 35
        List<String> solutionPath = solver.solve(initialState, 35);
        if (solutionPath != null) {
            // 最短步数是路径长度减一
            int steps = solutionPath.size() - 1;
            System.out.println(steps);
            // (可选) 打印移动路径
            System.out.println("移动路径如下:");
            for (String board : solutionPath) {
                printBoard(board);
                System.out.println("  ↓");
            }
        } else {
            System.out.println(-1);
        }
    }

    /**
     * 判断八数码问题是否有解（基于逆序对数量）。
     */
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

    private static void printBoard(String board) {
        for (int i = 0; i < board.length(); i++) {
            System.out.print(board.charAt(i) + " ");
            if ((i + 1) % N == 0) {
                System.out.println();
            }
        }
    }
}
