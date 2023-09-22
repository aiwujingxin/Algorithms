package leetcode.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/3 22:04
 */
public class LeetCode1654_WA {

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0});
        int furthest = x + a + b;
        if (x == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int j : forbidden) {
            set.add(j);
        }

        while (!queue.isEmpty()) {

            int[] n = queue.poll();

            if (n[0] == x) {
                return n[1];
            }
            int one = n[0] + a;
            if (one > 0 && one <= furthest && !set.contains(one)) {
                queue.add(new int[]{one, n[1] + 1, 1});
                set.add(one);
            }
            if (n[2] != -1) {
                int two = n[0] - b;
                if (two > 0 && two <= furthest && !set.contains(two)) {
                    queue.add(new int[]{two, n[1] + 1, -1});
                    set.add(two);
                }
            }
        }
        return -1;
    }
}
