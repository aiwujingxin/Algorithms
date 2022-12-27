package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 23:51
 */
public class LeetCode295_two_q {

    class MedianFinder {

        PriorityQueue<Integer> queMin;
        PriorityQueue<Integer> queMax;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            queMin = new PriorityQueue<>((a, b) -> (b - a));
            queMax = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        }

        public void addNum(int num) {
            if (queMin.isEmpty() || num < queMin.peek()) {
                queMin.offer(num);
                if (queMax.size() + 1 < queMin.size()) {
                    queMax.offer(queMin.poll());
                }
            } else {
                queMax.offer(num);
                if (queMax.size() > queMin.size()) {
                    queMin.offer(queMax.poll());
                }
            }
        }

        public double findMedian() {
            if (queMin.size() > queMax.size()) {
                return queMin.peek();
            }
            return (queMin.peek() + queMax.peek()) / 2.0;
        }
    }

}
