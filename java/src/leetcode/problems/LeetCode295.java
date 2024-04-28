package leetcode.problems;

import java.util.*;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 10:07
 */
public class LeetCode295 {

    class MedianFinder {

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (minQ.isEmpty() || num < minQ.peek()) {
                maxQ.add(num);
            } else {
                minQ.add(num);
            }
            if (minQ.size() > maxQ.size() + 1) {
                maxQ.add(minQ.poll());
            } else if (maxQ.size() > minQ.size()) {
                minQ.add(maxQ.poll());
            }
        }

        public double findMedian() {
            if (minQ.size() == maxQ.size()) {
                return ((double) minQ.peek() + maxQ.peek()) / 2;
            }
            return (double) minQ.peek();
        }
    }
}
