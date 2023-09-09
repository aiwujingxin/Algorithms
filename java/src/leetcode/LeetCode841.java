package leetcode;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/16 21:29
 */
public class LeetCode841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if (rooms == null || rooms.isEmpty()) {
            return false;
        }


        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited.add(0);

        while (!queue.isEmpty()) {
            int room = queue.poll();

            List<Integer> next = rooms.get(room);

            for (int n : next) {
                if (!visited.contains(n)) {
                    queue.add(n);
                    visited.add(n);
                }
            }
        }
        return visited.size() == rooms.size();

    }
}
