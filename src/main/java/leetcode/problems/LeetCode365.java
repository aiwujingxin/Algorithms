package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/19 23:28
 */
public class LeetCode365 {


    public static void main(String[] args) {
        System.out.println(new LeetCode365().canMeasureWater(104639, 104651, 234));
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[] a_visited = new boolean[1000000];
        boolean[] b_visited = new boolean[1000000];
        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int a = cur[0];
            int b = cur[1];

            if (a == targetCapacity || b == targetCapacity || a + b == targetCapacity) {
                return true;
            }

            if (a_visited[a] && b_visited[b]) {
                continue;
            }
            a_visited[a] = true;
            b_visited[b] = true;

            //case1
            queue.add(new int[]{jug1Capacity, b});
            queue.add(new int[]{a, jug2Capacity});

            //case2
            queue.add(new int[]{0, b});
            queue.add(new int[]{a, 0});

            //case3
            queue.add(new int[]{Math.min(jug1Capacity, a + b), Math.max(0, b - (jug1Capacity - a))});
            queue.add(new int[]{Math.max(0, a + b - jug2Capacity), Math.min(jug2Capacity, a + b)});
        }

        return false;
    }
}
