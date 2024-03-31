package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/3/31 13:56
 */
public class LeetCode1670 {

    class FrontMiddleBackQueue {

        private final Deque<Integer> left = new ArrayDeque<>();
        private final Deque<Integer> right = new ArrayDeque<>();

        public FrontMiddleBackQueue() {

        }

        public void pushFront(int val) {
            left.addFirst(val);
            balance();
        }

        public void pushMiddle(int val) {
            if (left.size() == right.size()) {
                right.addFirst(val);
            } else {
                left.addLast(val);
            }
            balance();
        }

        public void pushBack(int val) {
            right.addLast(val);
            balance();
        }

        public int popFront() {
            if (!left.isEmpty()) {
                int val = left.pollFirst();
                balance();
                return val;
            }
            if (!right.isEmpty()) {
                int val = right.pollFirst();
                balance();
                return val;
            }
            return -1;
        }

        public int popMiddle() {
            if (right.isEmpty()) {
                return -1;
            }
            if (left.size() == right.size()) {
                return left.pollLast();
            }
            return right.pollFirst();
        }

        public int popBack() {
            if (right.isEmpty()) {
                return -1;
            }
            int val = right.pollLast();
            balance();
            return val;
        }

        private void balance() {
            if (left.size() > right.size()) {
                right.addFirst(left.pollLast());
            } else if (right.size() > left.size() + 1) {
                left.addLast(right.pollFirst());
            }
        }
    }
}
