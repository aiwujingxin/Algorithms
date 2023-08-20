package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/3/24 17:21
 */
public class LeetCode362 {

    class HitCounter {

        Deque<Integer> queue;
        int sum;

        public HitCounter() {
            queue = new ArrayDeque<>();
            sum = 0;
        }

        public void hit(int timestamp) {
            if (queue.isEmpty()) {
                queue.add(timestamp);
                return;
            }
            while (!queue.isEmpty() && timestamp - queue.peekFirst() >= 299) {
                queue.pollFirst();
                queue.add(timestamp);
            }
        }

        public int getHits(int timestamp) {
            while (!queue.isEmpty() && timestamp - queue.peekFirst() >= 299) {
                queue.pollFirst();
                queue.add(timestamp);
            }
            return queue.size();
        }
    }
}
