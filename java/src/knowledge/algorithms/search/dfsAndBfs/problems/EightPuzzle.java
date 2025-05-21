package knowledge.algorithms.search.dfsAndBfs.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/23 15:32
 * @description 八数码 A* 曼哈顿距离作为启发式函数 + 康托展开来检查状态是否已访问
 * @example 样例
 * 1 2 3 0 8 4 7 6 5
 * 1 0 3 8 2 4 7 6 5
 * 2
 */

public class EightPuzzle {

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
