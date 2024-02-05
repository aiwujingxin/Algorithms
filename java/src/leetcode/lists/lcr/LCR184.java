package leetcode.lists.lcr;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 11:01
 */
public class LCR184 {

    class MaxQueue {

        Queue<Integer> queue;
        Deque<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new ArrayDeque<>();
        }

        public int max_value() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.peek();
        }

        public void push_back(int value) {
            while (!deque.isEmpty() && value > deque.peekLast()) {
                deque.pollLast();
            }
            queue.add(value);
            deque.offerLast(value);

        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int ans = queue.poll();
            if (ans == deque.peekFirst()) {
                deque.pollFirst();
            }
            return ans;
        }
    }
}
