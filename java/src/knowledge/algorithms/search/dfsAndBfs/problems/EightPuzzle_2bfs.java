package knowledge.algorithms.search.dfsAndBfs.problems;

import knowledge.algorithms.search.dfsAndBfs.bfs.BiBFS;

import java.util.*;
import java.util.function.Function;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/23 15:32
 * @description 八数码 双向BFS
 * @link <a href="https://www.acwing.com/solution/content/142925/"></a>
 */

public class EightPuzzle_2bfs {

    private static final String END_STATE = "12345678x";
    private static final int[] dx = {-1, 0, 1, 0}; // 上, 右, 下, 左
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder startBuilder = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            String input = scanner.next();
            char op = input.charAt(0);
            if (op != 'x') {
                sb.append(op);
            }
            startBuilder.append(op);
        }
        scanner.close();
        String startState = startBuilder.toString();
        // 检查是否有解
        if (hasOddInversions(sb.toString())) {
            System.out.println("-1");
            return;
        }

        // 2. 定义状态转移函数 getNeighbors
        Function<String, List<String>> getNeighbors = (currentState) -> {
            List<String> neighbors = new ArrayList<>();
            int xIndex = currentState.indexOf('x');
            int x = xIndex / 3;
            int y = xIndex % 3;
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                // 检查边界
                if (newX >= 0 && newX < 3 && newY >= 0 && newY < 3) {
                    char[] chars = currentState.toCharArray();
                    // 交换'x'和邻居
                    char temp = chars[newX * 3 + newY];
                    chars[newX * 3 + newY] = 'x';
                    chars[x * 3 + y] = temp;
                    neighbors.add(new String(chars));
                }
            }
            return neighbors;
        };
        // --- 3. 创建 BiBFS 实例并调用 ---
        BiBFS<String> bfs = new BiBFS<>();
        int steps = bfs.search(startState, END_STATE, getNeighbors);
        System.out.println(steps);
    }


    /**
     * 检查八数码问题的初始状态是否有解。
     * 通过计算逆序对的数量来判断。只有逆序对为偶数时才有解。
     *
     * @param state 不包含'x'的8位数字字符串。
     * @return 如果逆序对为奇数（无解），返回 true；否则返回 false。
     */
    private static boolean hasOddInversions(String state) {
        int inversions = 0;
        for (int i = 0; i < state.length(); i++) {
            for (int j = i + 1; j < state.length(); j++) {
                if (state.charAt(j) < state.charAt(i)) {
                    inversions++;
                }
            }
        }
        return (inversions & 1) == 1; // 使用位运算判断奇偶
    }
}
