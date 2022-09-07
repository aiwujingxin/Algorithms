package leetcode.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author jingxinwu
 * @date 2021-11-22 10:17 下午
 */
public class Offer41 {

    /**
     * 时间复杂度：
     *
     * addNum: O(logn)，其中 nn 为累计添加的数的数量。
     * findMedian: )O(1)。
     * 空间复杂度：O(n)，主要为优先队列的开销。
     */

    PriorityQueue<Integer> queMin;
    PriorityQueue<Integer> queMax;

    public Offer41() {
        queMin = new PriorityQueue<>((a, b) -> (b - a));
        queMax = new PriorityQueue<>(Comparator.comparingInt(a -> a));
    }

    public void addNum(int num) {
        if (queMin.isEmpty() || num <= queMin.peek()) {
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
