package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 00:42
 */
public class LeetCode295 {

    class MedianFinder {

        PriorityQueue<Integer> minQ;
        PriorityQueue<Integer> maxQ;

        public MedianFinder() {
            maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minQ = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxQ.isEmpty() || maxQ.peek() >= num) {
                maxQ.add(num);
            } else {
                minQ.add(num);
            }
            if (maxQ.size() > minQ.size() + 1) {
                minQ.add(maxQ.poll());
            } else if (minQ.size() > maxQ.size()) {
                maxQ.add(minQ.poll());
            }
        }

        public double findMedian() {
            if (minQ.isEmpty() || maxQ.size() > minQ.size()) {
                return maxQ.peek();
            }
            return (double) (maxQ.peek() + minQ.peek()) / 2;
        }
    }
}
