package leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/19 22:41
 * <a href="https://leetcode.com/problems/minimum-jumps-to-reach-home/discuss/935504/JAVA-BFS-and-DFS-solution">...</a>
 */
public class LeetCode1654_bfs {
    public static void main(String[] args) {
        System.out.println(new LeetCode1654_bfs().minimumJumps(new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11));
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if (x == 0) {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        HashSet<Integer> forbit = new HashSet<>();
        for (int j : forbidden) {
            forbit.add(j);
        }
        HashSet<String> visited = new HashSet<>();
        queue.add(new int[]{0, 0, 0});

        //fix  direction
        visited.add(0 + "," + 0);

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            if (pos[0] == x) {
                return pos[1];
            }
            // 贝祖定理
            if (pos[0] + a < 6000 && !forbit.contains(pos[0] + a) && !visited.contains(pos[0] + a + "," + 0)) {
                queue.add(new int[]{pos[0] + a, pos[1] + 1, 1});
                visited.add(pos[0] + a + "," + 0);
            }
            if (pos[0] - b >= 0 && pos[2] != -1 && !forbit.contains(pos[0] - b) && !visited.contains((pos[0] - b) + "," + -1)) {
                queue.add(new int[]{pos[0] - b, pos[1] + 1, -1});
                visited.add(pos[0] - b + "," + -1);
            }
        }
        return -1;
    }
}
