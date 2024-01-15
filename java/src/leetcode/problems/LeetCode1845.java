package leetcode.problems;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/1/15 17:14
 */
public class LeetCode1845 {

    class SeatManager {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        public SeatManager(int n) {
            for (int i = 1; i <= n; i++) {
                queue.add(i);
            }
        }

        public int reserve() {
            return queue.poll();
        }

        public void unreserve(int seatNumber) {
            queue.add(seatNumber);
        }
    }
}
