package leetcode.offer;

import java.util.PriorityQueue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/9/15 10:44
 */
public class Offer41 {


    class MedianFinder {

        PriorityQueue<Integer> q1;
        PriorityQueue<Integer> q2;

        public MedianFinder() {
            q1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
            q2 = new PriorityQueue<>();
        }

        // 优先加入q1
        // 确保q1 size >= q2 size
        public void addNum(int num) {
            if (q1.isEmpty() || num <= q1.peek()) {
                q1.offer(num);
                if (q2.size() + 1 < q1.size()) {
                    q2.offer(q1.poll());
                }
            } else {
                q2.offer(num);
                if (q1.size() < q2.size()) {
                    q1.offer(q2.poll());
                }
            }
        }

        public double findMedian() {
            if (q1.size() > q2.size()) {
                return q1.peek();
            }
            return (q1.peek() + q2.peek()) / 2.0;
        }
    }
}
