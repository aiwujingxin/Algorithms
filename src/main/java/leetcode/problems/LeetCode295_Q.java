package leetcode.problems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2022/10/6 23:56
 */
public class LeetCode295_Q {

    //https://leetcode.com/problems/find-median-from-data-stream/discuss/2668765/Java-100-Best-solution
    class MedianFinder {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxHeap.size() == 0 || maxHeap.peek() > num) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            }
            System.out.print(maxHeap.peek());
        }

        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek() / 1.0;
            } else if (minHeap.size() > maxHeap.size()) {
                return minHeap.peek() / 1.0;
            } else {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
        }
    }
}
