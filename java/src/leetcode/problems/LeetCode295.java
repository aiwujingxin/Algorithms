package leetcode.problems;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2024/4/26 10:07
 */
public class LeetCode295 {

    class MedianFinder {

        Queue<Integer> L = new PriorityQueue<>((a, b) -> b - a); // 最大堆
        Queue<Integer> R = new PriorityQueue<>();                             // 最小堆

        public void addNum(int num) {
            if (L.size() == R.size()) {
                R.add(num);
                L.add(R.poll());
            } else {
                L.add(num);
                R.add(L.poll());
            }
        }

        public double findMedian() {
            return (L.size() > R.size() ? L.peek() : (L.peek() + R.peek()) / 2.0);
        }
    }
}
