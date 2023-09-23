package leetcode.lists.offer;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 11:01
 */
public class Offer59_II {

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