package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wujingxinit@outlook.com
 * @date 2023/11/6 17:25
 */
public class LeetCode4 {

    Queue<Integer> maxQ;
    Queue<Integer> minQ;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        maxQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        minQ = new PriorityQueue<>();

        add(nums1);
        add(nums2);

        if ((nums1.length + nums2.length) % 2 == 1) {
            return maxQ.peek();
        }
        return ((double) maxQ.peek() + (double) minQ.peek()) / 2;
    }

    private void add(int[] nums) {
        for (int num : nums) {
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
    }
}
